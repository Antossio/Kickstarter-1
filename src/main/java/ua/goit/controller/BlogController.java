package ua.goit.controller;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import ua.goit.model.AuthorBlog;
import ua.goit.model.Comment;
import ua.goit.model.Project;
import ua.goit.service.BlogService;
import ua.goit.service.CommentService;
import ua.goit.service.ProjectService;
import ua.goit.service.UserService;

@Controller
public class BlogController {
  private static final Logger logger = Logger.getLogger(BlogController.class);
  private final ProjectService projectService;
  private final UserService userService;
  private final BlogService blogService;
  

  @Autowired
  public BlogController(ProjectService projectService, UserService userService, BlogService blogService) {
    this.projectService = projectService;
    this.userService = userService;
    this.blogService = blogService;
  } 

  @RequestMapping(value = "/addPost/{projectId}", method = RequestMethod.GET)
  public String addPost(Model model,
      @PathVariable int projectId){
    model.addAttribute("projectID", projectId);    
    return "addPost";
  }
  
  
  @RequestMapping(value = "/addPost", method = RequestMethod.POST)
  public RedirectView handleAddPostForProject(Model model,
      @RequestParam("userID") String userIdString,
      @RequestParam("post") String post,
      @RequestParam("projectID") String projectIdString) {
    RedirectView result;
    int projectId = Integer.parseInt(projectIdString);
    int userId = Integer.parseInt(userIdString);
    Project project = projectService.getById(projectId); 
    blogService.add(new AuthorBlog(post, project, project.getUser()));
    result = new RedirectView("http://localhost:8080/kickstarter/projects/"+projectIdString);
    return result;
  }
}
