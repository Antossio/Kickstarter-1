package ua.goit.controller;


import ua.goit.dao.CategoryDao;
import ua.goit.dao.Factory;
import ua.goit.dao.ProjectDao;
import ua.goit.factory.DaoFactory;
import ua.goit.model.Category;
import ua.goit.model.Project;
import ua.goit.model.User;
import ua.goit.service.CategoryService;
import ua.goit.service.CategoryServiceImpl;
import ua.goit.service.ProjectService;
import ua.goit.service.ProjectServiceImpl;
import ua.goit.servlet.Request;
import ua.goit.view.ModelAndView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryController implements Controller {
  @Override
  public ModelAndView handleRequest(Request request) {

    CategoryDao categoryDao = DaoFactory.getInstance().getDao(CategoryDao.class);
    ProjectDao projectDao = Factory.getDaoFactory().getProjectDao();
    CategoryService categoryService = new CategoryServiceImpl(categoryDao);
    ProjectService projectService = new ProjectServiceImpl(projectDao);
    List<Category> categories = categoryService.getAll();
    ModelAndView modelAndView = new ModelAndView("/categories.jsp");
    if (request.getParameters().isEmpty()) {
      modelAndView.addAttribute("categories", categories);
    } else {
      String categoryId = request.getParameters().get("category");
      List<Project> projects = projectService.
              getProjectsByCategoryId(Integer.valueOf(categoryId));
      modelAndView.addAttribute("projects", projects);
    }
    return modelAndView;
  }
}


