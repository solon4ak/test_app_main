package ru.solon4ak.test_app_main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.solon4ak.test_app_main.model.Device;
import ru.solon4ak.test_app_main.service.DeviceService;

import java.util.List;

@RestController
public class DeviceController {

    private DeviceService deviceService;

    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/{id}")
    public List<Device> getAllDevicesForProject(@PathVariable Long id) {
        return deviceService.getAllDevicesForProject(id);
    }
}
