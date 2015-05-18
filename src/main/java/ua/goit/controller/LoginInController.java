package ua.goit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.goit.model.User;
import ua.goit.service.LoginInService;

@Controller
public class LoginInController {
  private static final Logger logger = Logger.getLogger(LoginInController.class);
  private final LoginInService loginInService;

  @Autowired
  public LoginInController(LoginInService loginInService) {
	this.loginInService = loginInService;
  }
 
  @RequestMapping(value = "/login",method = RequestMethod.GET)
  
  public ModelAndView process(ModelAndView model) {
	return new ModelAndView ("loginIn");
  }
    
  @RequestMapping(value = "/login", method = RequestMethod.POST)

  public RedirectView process(@RequestParam("login") String login, @RequestParam("password") String password, 
	  Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	request.getAttribute("login");
	request.getAttribute("password");
	RedirectView result;
	User user = loginInService.getUser(login);
	Boolean state = loginInService.checkPassword(user, password);
	if (state == true) {
	  Cookie cookie = new Cookie("token", user.getToken());
	  response.addCookie(cookie);
	  result = new RedirectView("http://localhost:8080/kickstarter/home");
	} else 
	  result = new RedirectView("http://localhost:8080/kickstarter/signup"); 
	
	return result;
  }
}