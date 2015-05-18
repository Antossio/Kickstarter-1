package ua.goit.filter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import ua.goit.model.User;
import ua.goit.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Cookie[] cookies = req.getCookies();
		String tokenValue = null;
		if (cookies != null) {
			for (Cookie c : cookies) {
				logger.error(c.getName() + token.equals(c.getName()));
				if (token.equals(c.getName())) {
					tokenValue = c.getValue();
					User user = userService.findByToken(tokenValue);
					req.setAttribute("isLoggedIn", "true");
					req.setAttribute("user", user);
				}
			}
		}	   
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {

	}
}
