package ua.goit.servlet;

import ua.goit.annotation.ValidateAnnotation;
import ua.goit.controller.*;
import ua.goit.validator.AbstractValidator;
import org.apache.log4j.Logger;
import ua.goit.controller.CategoryController;
import ua.goit.controller.Controller;
import ua.goit.controller.ErrorController;
import ua.goit.controller.UserController;
import ua.goit.view.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {
  private final static Logger logger = Logger.getLogger(MainServlet.class);
  private final Map<Request, Controller> controllers = new HashMap();


    @Override
    public void init() throws ServletException {
        super.init();
        controllers.put(Request.create(Method.GET, "/user"), new UserController());
        controllers.put(Request.create(Method.GET, "/kickstarter/categories"), new CategoryController());
        controllers.put(Request.create(Method.POST, "/kickstarter/signup"), new SignUpController());
        controllers.put(Request.create(Method.GET, "/kickstarter/activation"), new ActivationController());
    }


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    logger.info("Start handling request from: " + req.getRequestURI());
    handleRequest(req, resp);
  }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Request request = new Request(req.getParameterMap(), req.getMethod(), req.getRequestURI());
        try {
            Controller controller = controllers.get(request);
            if (controller == null) {
                throw new RuntimeException("Page not Found!!!");
            } controller.getClass();
            Annotation annotation = controller.getClass().getAnnotation(ValidateAnnotation.class);
            AbstractValidator validatorInstance = null;

            if (annotation instanceof ValidateAnnotation) {
                ValidateAnnotation validateAnnotation = (ValidateAnnotation) annotation;
                validatorInstance = validateAnnotation.value().newInstance();
            }
            if (validatorInstance != null) {
                boolean result = validatorInstance.validate(request);
                if (!result) {
                    throw new RuntimeException("Wrong input");
                }
            }
            ModelAndView modelAndView = controller.handleRequest(request);
            setAttributes(req, modelAndView);
            forward(req, resp, modelAndView);
        } catch (Throwable t) {
            ModelAndView modelAndView = new ErrorController().handleRequest(request);
            modelAndView.addAttribute("error", t.getClass() + " " + t.getMessage());
            setAttributes(req, modelAndView);
            forward(req, resp, modelAndView);
        }
    }

    private void setAttributes(HttpServletRequest req, ModelAndView modelAndView) {
        for (String name : modelAndView.getAttributes().keySet()) {
            req.setAttribute(name, modelAndView.getAttribute(name));
        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp, ModelAndView modelAndView) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(getView(req, modelAndView));
        dispatcher.forward(req, resp);
    }

    private String getView(HttpServletRequest req, ModelAndView modelAndView) {
        return req.getContextPath() + modelAndView.getView();
    }
}
