package ru.solon4ak.test_app_main.service;

import ru.solon4ak.test_app_main.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();
    void addProject(Project project);
    Project findProject(Long id);
    Project updateProject(Project project);
    void deleteProject(Long id);
}
