package ua.goit.controller;

import ua.goit.service.CategoryService;

public class NewProjectController{
	private final CategoryService categoryService;
	
	public NewProjectController(CategoryService categoryService) {
	this.categoryService = categoryService;
	}
	
//	public ModelAndView handleRequest(Request request) {
//		List<Category> categories = categoryService.getAll();
//		ModelAndView modelAndView = new ModelAndView("/addProject.jsp");
//		if (request.getParameters().isEmpty()) {
//			modelAndView.addAttribute("categories", categories);
//		}
//		return modelAndView;
//	}

}
