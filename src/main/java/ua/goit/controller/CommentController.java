package ua.goit.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.model.Comment;
import ua.goit.model.Project;
import ua.goit.service.CommentService;
import ua.goit.service.ProjectService;
import ua.goit.service.UserService;

import java.util.Collections;
import java.util.List;

@Controller
public class CommentController {
  private static final Logger logger = Logger.getLogger(CommentController.class);
  private final ProjectService projectService;
  private final UserService userService;
  private final CommentService commentService;


  @Autowired
  public CommentController(ProjectService projectService, UserService userService, CommentService commentService) {
    this.projectService = projectService;
    this.userService = userService;
    this.commentService = commentService;
  }

  @RequestMapping(value = "/addComments", method = RequestMethod.POST)
  public RedirectView handleCommetForProject(Model model, @RequestParam("userID") String userIdString, @RequestParam("comment") String comment, @RequestParam("projectID") String projectIdString) {
    RedirectView result;
    int projectId = Integer.parseInt(projectIdString);
    int userId = Integer.parseInt(userIdString);
    Project project = projectService.getById(projectId);
    commentService.add(new Comment(comment, project, project.getUsers()));
    List<Comment> comments = project.getCommentList();
    Collections.sort(comments);
    model.addAttribute("project", project);
    model.addAttribute("comments", comments);
    result = new RedirectView("http://localhost:8080/kickstarter/projects/" + projectIdString);
    return result;
  }

}
