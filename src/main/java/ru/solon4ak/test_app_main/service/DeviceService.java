package ru.solon4ak.test_app_main.service;

import ru.solon4ak.test_app_main.model.Device;

import java.util.List;

public interface DeviceService {

    List<Device> getAllDevices();
    void addDevice(Device device);
    Device findDevice(Long id);
    Device updateDevice(Device device);
    void deleteDevice(Long id);
    List<Device> getAllDevicesForProject(Long id);
}
