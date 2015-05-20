package ua.goit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

  @RequestMapping(value = "/addProject", method = RequestMethod.GET)
  public String handleCategoriesListForNewProject(Model model) {
    List<Category> categories = categoryService.getAll();
    model.addAttribute("categories", categories);
    return "addProject";
  }

  @RequestMapping(value = "/projects", method = RequestMethod.GET)
  public String listProject(Model model,
      HttpServletRequest req) {
    int userId = Integer.parseInt((String)req.getAttribute("userID"));
    List<Project> projectList = projectService.getByUserId(userId);     
    model.addAttribute("projects", projectList);
    return "listProjects";
  }

  @RequestMapping(value = "/projects", method = RequestMethod.POST)
  public String addProject(Model model,  
      @RequestParam("categories") String categoryIdString,
      @RequestParam("projectName") String projectName,
      @RequestParam("projectShortDesc") String projectShortDesc, 
      @RequestParam("projectLongDesc") String projectLongDesc,
      @RequestParam("userID") String userIdString,
      @RequestParam("img") MultipartFile file) { 
    String linkToFile;
    int categoryId = Integer.parseInt(categoryIdString);
    int userId = Integer.parseInt(userIdString);
    Category categoryObject = categoryService.getById(categoryId);
    User userObject = userService.getById(userId);   
    if (!file.isEmpty()) {
      try {
        byte[] bytes = file.getBytes();
        // Creating the directory to store file
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "tmpFiles");
        if (!dir.exists()) {
          dir.mkdirs();
        }
        // Create the file on server
        linkToFile = dir.getAbsolutePath() + File.separator + file.getOriginalFilename();
        File serverFile = new File(linkToFile);
        BufferedOutputStream stream = new BufferedOutputStream(
            new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
        logger.info("Server File Location=" + serverFile.getAbsolutePath());
      } catch (Exception e) {
        return "error";
      }
    } else {
      return "error";
    }
    projectService.add(new Project(projectName, categoryObject, userObject, projectShortDesc, projectLongDesc, linkToFile));
    List<Project> projectList = projectService.getByUserId(userId);		
    model.addAttribute("projects", projectList);
    return "listProjects";
  }
  
  @RequestMapping(value = "/projects/{projectId}", method = RequestMethod.GET)
  public String showProject(Model model,
      @PathVariable int projectId) {
    Project project = projectService.getById(projectId);
    model.addAttribute("project", project);
    return "project";
  }
}
