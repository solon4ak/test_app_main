package ru.solon4ak.test_app_main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solon4ak.test_app_main.model.Event;
import ru.solon4ak.test_app_main.repository.EventRepository;

import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void addEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Event getEvent(Long id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

}
