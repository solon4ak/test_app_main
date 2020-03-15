package ru.solon4ak.test_app_main.service;

import ru.solon4ak.test_app_main.model.Event;

import java.util.List;

public interface EventService {

    List<Event> getAllEvents();
    void addEvent(Event event);
    Event getEvent(Long id);
    Event updateEvent(Event event);
    void deleteEvent(Long id);
}
