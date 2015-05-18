package ua.goit.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController{
  private static final Logger logger = Logger.getLogger(UserController.class);

  @RequestMapping(value = "/profile", method = RequestMethod.GET)
  public String forwardToProfile(Model model) {
	return "profile";  
  }
}