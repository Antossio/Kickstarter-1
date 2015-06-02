
package ua.goit.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.goit.annotation.ValidateAnnotation;
import ua.goit.model.Users;
import ua.goit.service.MailServiceSending;
import ua.goit.service.MailServiceSendingImpl;
import ua.goit.service.PasswordEncoder;
import ua.goit.service.UserService;
import ua.goit.validator.FormValidator;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@ValidateAnnotation(name = "formValidator", value = FormValidator.class)
public class SignUpController{
	private static final Logger logger = Logger.getLogger(SignUpController.class);
	private final UserService userService;

	@Autowired
	public SignUpController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(Model model){
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String handleSignUpRequest(Model model,
			@RequestParam("name") String name,
			@RequestParam("login") String login,
			@RequestParam("password") String password, 
			@RequestParam("email") String email) {
		String activationKey = generateActivationKey(login, email);
		Properties properties = loadProperties();
		Enumeration propertiesNames = properties.propertyNames();
		String serverEmail = "";
		String serverPass = "";
		String domain = "";
		while (propertiesNames.hasMoreElements()) {
			switch ((String) propertiesNames.nextElement()) {
			case "email":
				serverEmail = properties.getProperty("email");
				break;
			case "password":
				serverPass = properties.getProperty("password");
				break;
			case "domain":
				domain = properties.getProperty("domain");
				break;		
			}
		}

		userService.add(new Users(name, login, PasswordEncoder.encode(password), email, activationKey));
		MailServiceSending mailServiceSending = new MailServiceSendingImpl(serverEmail, serverPass);
		mailServiceSending.send("Activation letter!", domain + "kickstarter/activation?key=" + activationKey, serverEmail, email);
		return "confirm_registration";
	}

	@RequestMapping(value = "/activation", method = RequestMethod.GET)
	public String handleActivation(Model model,
			@RequestParam(value = "key") String activationKey,
			HttpServletResponse response) {
		if(activationKey.equals(null)) {
			model.addAttribute("error", "activation key not found");
			return "error";
		}
		Users users = userService.findByActivationKey(activationKey);
		if (users == null) {
			return "error";
		} 
		String token = 31 * users.getId() + users.getLogin().hashCode() + "";
		users.setToken(token);
		users.setIsActive(1);
		userService.update(users);
		response.addCookie(new Cookie("token", token)); 
		return "success_registration";
	}

	private Properties loadProperties() {
		InputStream is = getClass().getResourceAsStream("/ms.properties");
		Properties msProps = new Properties();
		try {
			msProps.load(is);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return msProps;
	}

	private String generateActivationKey(String login, String email) {
		return new Random().nextInt(Integer.MAX_VALUE) + "";

	}
}