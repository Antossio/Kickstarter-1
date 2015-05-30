package ua.goit.filter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.goit.model.User;
import ua.goit.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component("UserFilter")
public class UserFilter implements Filter {
  private static final Logger logger = Logger.getLogger(UserFilter.class);
  private final UserService userService;
  private final String token = "token";

  @Autowired
  public UserFilter(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    Cookie[] cookies = req.getCookies();
    String tokenValue;
    if (cookies != null) {
      for (Cookie c : cookies) {
        if (token.equals(c.getName())) {
          tokenValue = c.getValue();
          User user = userService.findByToken((tokenValue));
          req.setAttribute("userName", user.getName());
          req.setAttribute("userID", String.valueOf(user.getId()));
          req.setAttribute("isLoggedIn", "true");
          req.setAttribute("user", user);
        } 
      } 
    }

    if (req.getRequestURI().equals("/kickstarter/logout")) {
      req.setAttribute("isLoggedIn", "false");
      Cookie[] cookie = req.getCookies();
      for (Cookie c : cookie) {
        if (token.equals(c.getName())) {
          c.setMaxAge(0);
          res.addCookie(c);
        }
      }
    }
    chain.doFilter(req, res);
  }

  @Override
  public void destroy() {
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // TODO Auto-generated method stub

  }
}
