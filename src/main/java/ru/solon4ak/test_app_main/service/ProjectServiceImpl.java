package ru.solon4ak.test_app_main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solon4ak.test_app_main.model.Device;
import ru.solon4ak.test_app_main.model.Event;
import ru.solon4ak.test_app_main.model.Project;
import ru.solon4ak.test_app_main.model.Stats;
import ru.solon4ak.test_app_main.repository.ProjectRepository;
import ru.solon4ak.test_app_main.util.DateConverter;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private DateConverter dateConverter;

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setDateConverter(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        for (Project p : projects) {
            Stats stats = p.getStats();
            for (Device d : p.getDevices()) {
                boolean hasErrors = false;
                for (Event e : d.getEvents()) {
                    switch (e.getType()) {
                        case EVENT:
                            continue;
                        case ERROR:
                        case WARNING:
                        default:
                            if (dateConverter.convertToLocalDateTime(e.getDate())
                                    .isAfter(LocalDateTime.now().minusHours(24L))) {
                                hasErrors = true;
                            }
                            break;

                    }
                }
                stats.setDeviceCount(stats.getDeviceCount() + 1);
                if (hasErrors) {
                    stats.setDeviceWithErrors(stats.getDeviceWithErrors() + 1);
                } else {
                    stats.setStableDevices(stats.getStableDevices() + 1);
                }
            }
        }

        return projects;
    }

    @Override
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project findProject(Long id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
