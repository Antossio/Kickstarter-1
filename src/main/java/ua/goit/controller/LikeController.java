package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.model.Like;
import ua.goit.model.Project;
import ua.goit.model.Users;
import ua.goit.service.LikeService;
import ua.goit.service.ProjectService;
import ua.goit.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LikeController {
  private final UserService userService;
  private final ProjectService projectService;
  private final LikeService likeService;

  @Autowired
  public LikeController(ProjectService projectService, UserService userService, LikeService likeService) {
    this.projectService = projectService;
    this.userService = userService;
    this.likeService = likeService;
  }

  @RequestMapping(value = "/like", method = RequestMethod.POST)
  public RedirectView likeProject(Model model,
                                  @RequestParam("userName") String login,
                                  @RequestParam("projectId") int projectId) {
    RedirectView result;
    Project project = projectService.getById(projectId);
    int likesQty = project.getLikesQty();
    likesQty++;
    likeService.add(new Like(project, userService.getByLogin(login)));
    project.setLikesQty(likesQty);
    projectService.update(project);
    result = new RedirectView("/kickstarter/categories/" + project.getCategory().getId());
    return result;
  }

  @RequestMapping(value = "/unlike", method = RequestMethod.POST)
  public RedirectView unlikeProject(Model model,
                                    @RequestParam("userName") String login,
                                    @RequestParam("projectId") int projectId,
                                    HttpServletRequest req) {
    RedirectView result;
    Project project = projectService.getById(projectId);
    int likesQty = project.getLikesQty();
    likesQty--;
    project.setLikesQty(likesQty);
    List<Like> likeList = likeService.getAllByProjectId(projectId);
    Users user = userService.getByLogin(login);
    Like likeWithIUserEntity = new Like();
    for (Like l : likeList) {
      likeWithIUserEntity = likeService.getById(l.getId());
      if (likeWithIUserEntity.getUsers().getId() == user.getId()) {
      }
    }
    projectService.update(project);
    likeService.remove(likeWithIUserEntity.getId());
    result = new RedirectView("/kickstarter/categories/" + project.getCategory().getId());
    return result;
  }
}
