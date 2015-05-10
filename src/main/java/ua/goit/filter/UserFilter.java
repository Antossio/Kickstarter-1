package ua.goit.filter;

import org.apache.log4j.Logger;
import ua.goit.model.User;
import ua.goit.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserFilter implements Filter {
  private static final Logger logger = Logger.getLogger(UserFilter.class);
  private final UserService userService;
  private String token = "token";

  public UserFilter(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    Cookie[] cookies = req.getCookies();
    String tokenValue = null;
    if (cookies != null) {
      for (Cookie c : cookies) {
        if (token.equals(c.getName())) {
          tokenValue = c.getValue();
          User user = userService.findByToken(tokenValue);
          req.setAttribute("userID", user.getId());
        }
      }
    }
    chain.doFilter(req, response);
  }

  @Override
  public void destroy() {

  }
}
