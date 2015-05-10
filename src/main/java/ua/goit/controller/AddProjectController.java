package ua.goit.controller;

import org.apache.log4j.Logger;
import ua.goit.service.CategoryService;
import ua.goit.service.ProjectService;
import ua.goit.service.UserService;

public class AddProjectController{
	private static final Logger logger = Logger.getLogger(AddProjectController.class);
	private final ProjectService projectService;
	private final CategoryService categoryService;
	private final UserService userService;
	
	

	public AddProjectController(ProjectService projectService, CategoryService categoryService, UserService userService) {
		this.projectService = projectService;
		this.categoryService = categoryService;
		this.userService = userService;		
	}	

//	@Override
//	public ModelAndView handleRequest(Request request) {
//		Map<String, String> param = request.getParameters();
//		int categoryId = Integer.parseInt(param.get("categories"));
//		int userId = Integer.parseInt(param.get("userID"));
//		Category category = categoryService.getById(categoryId);
//		User user = userService.getById(userId);
//		String name = param.get("projectName");
//		String shortDesc = param.get("projectShortDesc");
//		String longDesc = param.get("projectLongDesc");
//		String link = param.get("img");
//		projectService.add(new Project(name, category, user, shortDesc, longDesc, link));
//		ModelAndView modelAndView = new ModelAndView("/listProject.jsp");
//		List<Project> projectList = projectService.getByUserId(userId);
//		modelAndView.addAttribute("projects", projectList);
//		return modelAndView;
//	}
}
