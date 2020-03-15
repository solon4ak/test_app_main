package ru.solon4ak.test_app_main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.solon4ak.test_app_main.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
