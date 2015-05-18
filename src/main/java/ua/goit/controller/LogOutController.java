package ua.goit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogOutController {

  private static final Logger logger = Logger.getLogger(LogOutController.class);
  private String token = "token";
  
  @RequestMapping(value = "/logout",method = RequestMethod.POST)
  public void doLogout(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Cookie[] cookie = request.getCookies();
	for (Cookie c : cookie) {
	  if (token.equals(c.getName())) {
		c.setMaxAge(0);
		response.addCookie(c);
	  }
	}
	response.sendRedirect("/kickstarter/logout");
  }
  
  @RequestMapping(value = "/logout",method = RequestMethod.GET)
  public void redirectFromLogout(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.sendRedirect("/kickstarter/home");
  }
}