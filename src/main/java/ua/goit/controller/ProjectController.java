package ua.goit.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.goit.service.CategoryService;
import ua.goit.service.ProjectService;
import ua.goit.service.UserService;
import ua.goit.model.*;

@Controller
public class ProjectController {
	private static final Logger logger = Logger.getLogger(ProjectController.class);
	private final ProjectService projectService;
	private final CategoryService categoryService;
	private final UserService userService;

	@Autowired
	public ProjectController(ProjectService projectService, CategoryService categoryService, UserService userService) {
		this.projectService = projectService;
		this.categoryService = categoryService;
		this.userService = userService;		
	}	

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String newProject(Model model) {
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		return "addProject";
	}

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public String addProject(Model model,  
			@RequestParam("categories") String categoryIdString,
			@RequestParam("projectName") String projectName,
			@RequestParam("projectShortDesc") String projectShortDesc, 
			@RequestParam("projectLongDesc") String projectLongDesc,
			@RequestParam("userID") String userIdString,
			@RequestParam("img") String fileName,
			@RequestParam("img") MultipartFile file) {
		int categoryId = Integer.parseInt(categoryIdString);
		int userId = Integer.parseInt(userIdString);
		Category categoryObject = categoryService.getById(categoryId);
		User userObject = userService.getById(userId);
		projectService.add(new Project(projectName, categoryObject, userObject, projectShortDesc, projectLongDesc, fileName));
		List<Project> projectList = projectService.getByUserId(userId);		
		model.addAttribute("projects", projectList);
		return "listProject";
	}
}