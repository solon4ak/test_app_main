package ru.solon4ak.test_app_main.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "device_id")
    private Device device;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Enumerated(EnumType.STRING)
    private EventType type;

    private boolean is_read;

    public Event() {
    }

    public Event(Device device) {
        this.device = device;
        this.is_read = false;
    }

    public Long getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public boolean isIs_read() {
        return is_read;
    }

    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return is_read == event.is_read &&
                id.equals(event.id) &&
                device.equals(event.device) &&
                Objects.equals(date, event.date) &&
                type == event.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, device, date, type, is_read);
    }
}
