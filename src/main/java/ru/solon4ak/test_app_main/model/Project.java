package ru.solon4ak.test_app_main.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Scope;
import ru.solon4ak.test_app_main.util.ProjectSerializer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@JsonSerialize(using = ProjectSerializer.class)
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String projectName;

    @OneToMany(mappedBy = "project", orphanRemoval = true)
    private Collection<Device> devices;

    @Transient
    @JsonProperty("stats")
    private Stats stats;

    public Project() {
        stats = new Stats(0, 0, 0);
    }

    public Project(String name) {
        this.projectName = name;
        devices = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return projectName;
    }

    public void setName(String name) {
        this.projectName = name;
    }

    public Collection<Device> getDevices() {
        return devices;
    }

    public void setDevices(Collection<Device> devices) {
        this.devices = devices;
    }

    public void addDevice(Device device) {
        device.setProject(this);
        this.devices.add(device);
    }

    public void removeDevice(Device device) {
        device.setProject(null);
        this.devices.remove(device);
    }

    public int getDeviceCount() {
        return this.devices.size();
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
