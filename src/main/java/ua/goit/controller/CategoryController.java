package ua.goit.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.goit.model.Category;
import ua.goit.model.Project;
import ua.goit.model.Users;
import ua.goit.service.CategoryService;
import ua.goit.service.LikeService;
import ua.goit.service.ProjectService;

import java.util.List;

@Controller
public class CategoryController {
  private static final Logger logger = Logger.getLogger(CategoryController.class);
  private ProjectService projectService;
  private CategoryService categoryService;
  private LikeService likeService;
  

  @Autowired
  public CategoryController(CategoryService categoryService, ProjectService projectService, LikeService likeService) {
    this.categoryService = categoryService;
    this.projectService = projectService;
    this.likeService = likeService;
  }

  @RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.GET)
  public String showProjectsByCategory(Model model, @PathVariable int categoryId) {
    List<Project> projects = projectService.getProjectsByCategoryId(Integer.valueOf(categoryId));    
    model.addAttribute("projects", projects);
    return "projects";
  }

  @RequestMapping(value = "/categories/", method = RequestMethod.POST)
  public String addCategory(Model model, 
      @RequestParam("categoryName") String categoryName) {
    categoryService.add(new Category(categoryName));
    List<Category> categories = categoryService.getAll();
    model.addAttribute("categories", categories);
    return "categories";
  }

  @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
  public String addCategory(Model model) {
  return "addCategory";
  }
}

