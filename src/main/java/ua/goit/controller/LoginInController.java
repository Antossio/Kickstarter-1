package ua.goit.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
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

  @RequestMapping(value = "/loginIn", method = RequestMethod.GET)
  public String loginForm() {
	new ModelAndView("loginIn");
	return "loginIn" ;
  }

  @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
  public String process(Model model,
	  @RequestParam("login") String login,
	  @RequestParam("password") String password,
	  HttpServletResponse response) {
	User user = loginInService.getUser(login);
	Boolean state = loginInService.checkPassword(user, password);
	String result;
	if (state == true) {
		String token = user.getToken();
		response.addCookie(new Cookie("token", token));
		result = "redirect:/kickstarter/home";
	} else 
	  result = "signup"; //TODO rewrite to redirect:signup when SignupController will done (for clear mapping)
	return result;
  }
}