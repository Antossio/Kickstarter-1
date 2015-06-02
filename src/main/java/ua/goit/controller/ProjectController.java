package ua.goit.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.goit.model.*;
import ua.goit.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
public class ProjectController {
  private static final Logger logger = Logger.getLogger(ProjectController.class);
  private final ProjectService projectService;
  private final CategoryService categoryService;
  private final UserService userService;
  private final CommentService commentService;
  private final BlogService blogService;


  @Autowired
  public ProjectController(ProjectService projectService, CategoryService categoryService, UserService userService, CommentService commentService, BlogService blogService) {
    this.projectService = projectService;
    this.categoryService = categoryService;
    this.userService = userService;
    this.commentService = commentService;
    this.blogService = blogService;

  }

  @RequestMapping(value = "/addProject", method = RequestMethod.GET)
  public String handleCategoriesListForNewProject(Model model) {
    List<Category> categories = categoryService.getAll();
    model.addAttribute("categories", categories);
    return "addProject";
  }

  @RequestMapping(value = "/projects", method = RequestMethod.GET)
  public String listProject(Model model, HttpServletRequest req) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Users userFromDB = userService.getByLogin(user.getUsername());
    List<Project> projectList = projectService.getByUserId(userFromDB.getId());
    model.addAttribute("projects", projectList);
    return "listProjects";
  }

  @RequestMapping(value = "/projects", method = RequestMethod.POST)
  public String addProject(Model model,
                           @RequestParam("categories") String categoryIdString,
                           @RequestParam("projectName") String projectName,
                           @RequestParam("projectShortDesc") String projectShortDesc,
                           @RequestParam("projectLongDesc") String projectLongDesc,
                           @RequestParam("linkToFile") String linkToFile,
                           @RequestParam("img") MultipartFile file) {

    int categoryId = Integer.parseInt(categoryIdString);
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Users userFromDB = userService.getByLogin(user.getUsername());
    Category categoryObject = categoryService.getById(categoryId);
    Users userObject = userService.getById(userFromDB.getId());
    if (!file.isEmpty()) {
      linkToFile = saveToFile(file);
    }
    projectService.add(new Project(projectName, categoryObject, userObject, projectShortDesc, projectLongDesc, linkToFile));
    List<Project> projectList = projectService.getByUserId(userFromDB.getId());
    model.addAttribute("projects", projectList);
    return "listProjects";
  }

  @RequestMapping(value = "/updateProject/{projectId}", method = RequestMethod.POST)
  public String updateProject(Model model,
                              @PathVariable int projectId,
                              @RequestParam("categories") String categoryIdString,
                              @RequestParam("projectName") String projectName,
                              @RequestParam("projectShortDesc") String projectShortDesc,
                              @RequestParam("projectLongDesc") String projectLongDesc,
                              @RequestParam("linkToFile") String linkToFile,
                              @RequestParam("img") MultipartFile file) {
    int categoryId = Integer.parseInt(categoryIdString);
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Users userFromDB = userService.getByLogin(user.getUsername());
    Category categoryObject = categoryService.getById(categoryId);
    if (!file.isEmpty()) {
      linkToFile = saveToFile(file);
    }
    Project project = projectService.getById(projectId);
    project.setCategory(categoryObject);
    project.setName(projectName);
    project.setShortDesc(projectShortDesc);
    project.setLongDesc(projectLongDesc);
    project.setLink(linkToFile);
    projectService.update(project);
    List<Project> projectList = projectService.getByUserId(userFromDB.getId());
    model.addAttribute("projects", projectList);
    return "listProjects";
  }

  @RequestMapping(value = "/projects/{projectId}", method = RequestMethod.GET)
  public String showProject(Model model, @PathVariable int projectId) {
    Project project = projectService.getById(projectId);
    List<Comment> comments = project.getCommentList();
    List<AuthorBlog> posts = project.getPostList();
    model.addAttribute("project", project);
    model.addAttribute("comments", comments);
    model.addAttribute("posts", posts);
    return "project";
  }

  @RequestMapping(value = "/updateProjects/{projectId}", method = RequestMethod.GET)
  public String updateFormProject(Model model, @PathVariable int projectId) {
    Project project = projectService.getById(projectId);
    List<Category> categories = categoryService.getAll();
    model.addAttribute("categories", categories);
    model.addAttribute("project", project);
    return "updateProject";
  }

  @RequestMapping(value = "/dropProjects/{projectId}", method = RequestMethod.GET)
  public String dropProject(Model model, HttpServletRequest req,
                            @PathVariable int projectId) {
    //   Project project = projectService.getById(projectId);
    projectService.remove(projectId);
    int userId = Integer.parseInt((String) req.getAttribute("userID"));
    List<Project> projectList = projectService.getByUserId(userId);
    model.addAttribute("projects", projectList);
    return "listProjects";
  }

  public String saveToFile(MultipartFile file) {
    String linkToFile;
    try {
      byte[] bytes = file.getBytes();
      // Creating the directory to store file
      String rootPath = System.getProperty("catalina.home");
      File dir = new File(rootPath + File.separator + "image");
      if (!dir.exists()) {
        dir.mkdirs();
      }
      // Create the file on server
      linkToFile = dir.getAbsolutePath() + File.separator + file.getOriginalFilename();
      File serverFile = new File(linkToFile);
      BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
      stream.write(bytes);
      stream.close();
      logger.info("Server File Location=" + serverFile.getAbsolutePath());
    } catch (Exception e) {
      return "error";
    }
    return linkToFile;
  }
}
