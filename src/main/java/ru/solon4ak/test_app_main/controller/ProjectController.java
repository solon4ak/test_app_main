package ru.solon4ak.test_app_main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.solon4ak.test_app_main.model.Project;
import ru.solon4ak.test_app_main.service.ProjectService;

import java.util.List;

@RestController
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

}
