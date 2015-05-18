package ua.goit.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.annotation.ValidateAnnotation;
import ua.goit.service.UserService;
import ua.goit.validator.FormValidator;

import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

@ValidateAnnotation(name = "formValidator", value = FormValidator.class)
@Controller
public class SignUpController{
  private static final Logger logger = Logger.getLogger(SignUpController.class);
  private final UserService userService;

  @Autowired
  public SignUpController(UserService userService) {
    this.userService = userService;
  }
  @RequestMapping(value = "/signup")
  public String addCategory(Model model) {
    return "signup";
  }
//  @Override
//  public ModelAndView handleRequest(Request request) {
//    logger.info("Start execute" + SignUpController.class.getName());
//    Map<String, String> parameters = request.getParameters();
//    String name = parameters.get("name");
//    String login = parameters.get("login");
//    String password = parameters.get("password");
//    String email = parameters.get("email");
//
//    String activationKey = generateActivationKey(login, email);
//    Properties properties = loadProperties();
//    Enumeration propertiesNames = properties.propertyNames();
//
//    String serverEmail = "";
//    String serverPass = "";
//    String domain = "";
//
//    while (propertiesNames.hasMoreElements()) {
//      switch ((String) propertiesNames.nextElement()) {
//        case "email":
//          serverEmail = properties.getProperty("email");
//          break;
//        case "password":
//          serverPass = properties.getProperty("password");
//          break;
//        case "domain":
//          domain = properties.getProperty("domain");
//          break;
//        default:
//          break;
//      }
//    }
//
//    userService.add(new User(name, login, password, email, activationKey));
//    MailServiceSending mailServiceSending = new MailServiceSendingImpl(serverEmail, serverPass);
//    mailServiceSending.send("Activation letter!", domain + "kickstarter/activation?key=" + activationKey, serverEmail, email);
//    ModelAndView modelAndView = new ModelAndView("/confirm_registration.jsp");
//    return modelAndView;
//  }

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