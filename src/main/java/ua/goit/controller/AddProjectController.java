package ua.goit.controller;

import java.util.List;
import ua.goit.dao.CategoryDao;
import ua.goit.model.Category;
import ua.goit.service.CategoryService;
import ua.goit.service.CategoryServiceImpl;
import ua.goit.servlet.Request;
import ua.goit.view.ModelAndView;

public class AddProjectController implements Controller{
	private final CategoryService categoryService;
	
	public AddProjectController(CategoryService categoryService) {
	this.categoryService = categoryService;
	}
	
	@Override
	public ModelAndView handleRequest(Request request) {
		List<Category> categories = categoryService.getAll();
		ModelAndView modelAndView = new ModelAndView("/addProject.jsp");
		if (request.getParameters().isEmpty()) {
			modelAndView.addAttribute("categories", categories);
		} 
		return modelAndView;
	}

}
