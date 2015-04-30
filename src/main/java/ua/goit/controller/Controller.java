package ua.goit.controller;

import ua.goit.servlet.Request;
import ua.goit.view.*;

public interface Controller {
  ModelAndView handleRequest(Request request);
}
