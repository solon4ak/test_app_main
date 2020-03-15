package ru.solon4ak.test_app_main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.solon4ak.test_app_main.model.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

}
