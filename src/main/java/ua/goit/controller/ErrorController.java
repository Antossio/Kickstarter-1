package ua.goit.controller;

import ua.goit.servlet.Request;
import ua.goit.view.ModelAndView;

public class ErrorController implements Controller {

  @Override
  public ModelAndView handleRequest(Request request) {
    ModelAndView modelAndView = new ModelAndView("/error.jsp");
    modelAndView.addAttribute("error", request.getParameters().get("error"));
    return modelAndView;
  }
}
