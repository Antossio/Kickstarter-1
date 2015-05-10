package ua.goit.controller;

import org.apache.log4j.Logger;
import ua.goit.service.UserService;

public class ActivationController{
	private final static Logger logger = Logger.getLogger(ActivationController.class);
	private final UserService userService;

	public ActivationController(UserService userService) {
		this.userService = userService;
	}

//	@Override
//	public ModelAndView handleRequest(Request request) {
//		logger.info("Start execute" + ActivationController.class.getName());
//		ModelAndView error = new ModelAndView("/error.jsp");
//
//		if (request.getParameters().get("key").isEmpty()) {
//			return error;
//		} else {
//			String key = request.getParameters().get("key");
//			User user = userService.findByActivationKey(key);
//			if (user == null) {
//				return error;
//			} else {
//				String token = 31 * user.getId() + user.getLogin().hashCode() + "";
//				user.setToken(token);
//				user.setIsActive(1);
//				userService.update(user);
//				return new ModelAndView("/success_registration.jsp").setCookie("token", token);
//			}
//		}
//	}
}


