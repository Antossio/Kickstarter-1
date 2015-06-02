package ua.goit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginInController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String process(Model model, @RequestParam(value = "error", required = false) String error) {
    if (error != null) {
      model.addAttribute("error", "Invalid username or password!");
    }
    return "loginIn";
  }

}
