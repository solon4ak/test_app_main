package ru.solon4ak.test_app_main.util;

import org.springframework.beans.factory.annotation.Autowired;
import ru.solon4ak.test_app_main.model.Device;
import ru.solon4ak.test_app_main.model.Event;
import ru.solon4ak.test_app_main.model.EventType;
import ru.solon4ak.test_app_main.model.Project;
import ru.solon4ak.test_app_main.service.DeviceService;
import ru.solon4ak.test_app_main.service.EventService;
import ru.solon4ak.test_app_main.service.ProjectService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TestDataInit {

    private ProjectService projectService;
    private DeviceService deviceService;
    private EventService eventService;

    private DateConverter dateConverter;

    private List<Project> projects = new ArrayList<>();
    private List<Device> devices = new ArrayList<>();
    private List<Event> events = new ArrayList<>();

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Autowired
    public void setDateConverter(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }

    public TestDataInit() {
    }

    private void init() {
        createProjects();
        createDevices();
        createEvents();
    }

    private void createProjects() {
        Project projectA = new Project("Project A");
        projectService.addProject(projectA);
        projects.add(projectA);

        Project projectB = new Project("Project B");
        projectService.addProject(projectB);
        projects.add(projectB);

        Project projectC = new Project("Project C");
        projectService.addProject(projectC);
        projects.add(projectC);
    }

    private void createDevices() {

        Project projectA = projects.get(0);

        Device deviceA = new Device("4BCD");
        deviceA.setProject(projectA);
        deviceService.addDevice(deviceA);
        devices.add(deviceA);

        Device deviceB = new Device("4CDE");
        deviceB.setProject(projectA);
        deviceService.addDevice(deviceB);
        devices.add(deviceB);

        Device deviceC = new Device("4DEF");
        deviceC.setProject(projectA);
        deviceService.addDevice(deviceC);
        devices.add(deviceC);

        Project projectB = projects.get(1);

        deviceA = new Device("5BCD");
        deviceA.setProject(projectB);
        deviceService.addDevice(deviceA);
        devices.add(deviceA);

        deviceB = new Device("5CDE");
        deviceB.setProject(projectB);
        deviceService.addDevice(deviceB);
        devices.add(deviceB);

        deviceC = new Device("5DEF");
        deviceC.setProject(projectB);
        deviceService.addDevice(deviceC);
        devices.add(deviceC);

        Project projectC = projects.get(2);

        deviceA = new Device("6BCD");
        deviceA.setProject(projectC);
        deviceService.addDevice(deviceA);
        devices.add(deviceA);

        deviceB = new Device("6CDE");
        deviceB.setProject(projectC);
        deviceService.addDevice(deviceB);
        devices.add(deviceB);

        deviceC = new Device("6DEF");
        deviceC.setProject(projectC);
        deviceService.addDevice(deviceC);
        devices.add(deviceC);
    }

    private void createEvents() {

        /*  Events for device 1  */
        Device device = devices.get(0);

        Event event = new Event(device);
        event.setType(EventType.EVENT);
        event.setDate(dateConverter.convertToDate(
                LocalDateTime.now().minus(10L, ChronoUnit.HOURS))
        );
        eventService.addEvent(event);
        deviceService.updateDevice(device);
        events.add(event);

        event = new Event(device);
        event.setType(EventType.WARNING);
        event.setDate(dateConverter.convertToDate(
                LocalDateTime.now().minus(5L, ChronoUnit.HOURS))
        );
        eventService.addEvent(event);
        deviceService.updateDevice(device);
        events.add(event);

        event = new Event(device);
        event.setType(EventType.WARNING);
        event.setDate(dateConverter.convertToDate(
                LocalDateTime.now().minus(26L, ChronoUnit.HOURS))
        );
        eventService.addEvent(event);
        deviceService.updateDevice(device);
        events.add(event);

        /*  Events for device 2  */
        device = devices.get(1);

        event = new Event(device);
        event.setType(EventType.ERROR);
        event.setDate(dateConverter.convertToDate(
                LocalDateTime.now().minus(10L, ChronoUnit.HOURS))
        );
        eventService.addEvent(event);
        deviceService.updateDevice(device);
        events.add(event);

        event = new Event(device);
        event.setType(EventType.WARNING);
        event.setDate(dateConverter.convertToDate(
                LocalDateTime.now().minus(7L, ChronoUnit.HOURS))
        );
        eventService.addEvent(event);
        deviceService.updateDevice(device);
        events.add(event);

        event = new Event(device);
        event.setType(EventType.EVENT);
        event.setDate(dateConverter.convertToDate(
                LocalDateTime.now().minus(32L, ChronoUnit.HOURS))
        );
        eventService.addEvent(event);
        deviceService.updateDevice(device);
        events.add(event);

        /*  Events for device 3  */
        device = devices.get(4);

        event = new Event(device);
        event.setType(EventType.ERROR);
        event.setDate(dateConverter.convertToDate(
                LocalDateTime.now().minus(2L, ChronoUnit.DAYS))
        );
        eventService.addEvent(event);
        deviceService.updateDevice(device);
        events.add(event);

        event = new Event(device);
        event.setType(EventType.ERROR);
        event.setDate(dateConverter.convertToDate(
                LocalDateTime.now().minus(7L, ChronoUnit.HOURS))
        );
        eventService.addEvent(event);
        deviceService.updateDevice(device);
        events.add(event);

        event = new Event(device);
        event.setType(EventType.WARNING);
        event.setDate(dateConverter.convertToDate(
                LocalDateTime.now().minus(12L, ChronoUnit.HOURS))
        );
        eventService.addEvent(event);
        deviceService.updateDevice(device);
        events.add(event);

        event = new Event(device);
        event.setType(EventType.EVENT);
        event.setDate(dateConverter.convertToDate(
                LocalDateTime.now().minus(2L, ChronoUnit.HOURS))
        );
        eventService.addEvent(event);
        deviceService.updateDevice(device);
        events.add(event);
    }
}
