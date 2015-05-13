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
import ua.goit.model.User;
import ua.goit.service.CategoryService;
import ua.goit.service.ProjectService;
import ua.goit.service.UserService;

import java.util.List;

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

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String getAllProjects(Model model) {
        List<Project> projects = projectService.getAll();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @RequestMapping(value = "/projects/{project_id}", method = RequestMethod.GET)
    public String getProjectById(Model model, @PathVariable int projectId) {
        Project project = projectService.getById(projectId);
        model.addAttribute("project", project);
        return "project";
    }

    @RequestMapping(value = "/projects/{project_id}", method = RequestMethod.POST)
    public void addProject(@PathVariable Integer categoryId,
                           @RequestParam(value = "projectName") String projectName,
                           @RequestParam(value = "projectShortDesc") String projectShortDesc,
                           @RequestParam(value = "projectLongDesc") String projectLongDesc,
                           @RequestParam(value = "userID") Integer userID,
                           @RequestParam(value = "img") String link) {
        User user = userService.getById(userID);
        Category category = categoryService.getById(categoryId);
        projectService.add(new Project(projectName, category, user, projectShortDesc, projectLongDesc, link));
    }
}
