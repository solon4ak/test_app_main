package ru.solon4ak.test_app_main.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.solon4ak.test_app_main.util.DeviceSerializer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "devices")
@JsonSerialize(using = DeviceSerializer.class)
public class Device {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "project_id")
    private Project project;

    private String serial_number;

    @OneToMany(mappedBy = "device", orphanRemoval = true)
    private Collection<Event> events;

    @Transient
    private SummaryInfo summaryInfo;

    @Transient
    private boolean hasErrors;

    public Device() {
        summaryInfo = new SummaryInfo(0, 0, 0);
    }

    public Device(String serial_number) {
        this.serial_number = serial_number;
        hasErrors = false;
        events = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public Collection<Event> getEvents() {
        return events;
    }

    public void setEvents(Collection<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event) {
        event.setDevice(this);
        this.events.add(event);
    }

    public void removeEvent(Event event) {
        event.setDevice(null);
        this.events.remove(event);
    }

    public int getEventsCount() {
        return this.events.size();
    }

    public SummaryInfo getSummaryInfo() {
        return summaryInfo;
    }

    public void setSummaryInfo(SummaryInfo summaryInfo) {
        this.summaryInfo = summaryInfo;
    }

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return id.equals(device.id) &&
                project.equals(device.project) &&
                serial_number.equals(device.serial_number) &&
                Objects.equals(events, device.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, project, serial_number);
    }
}
