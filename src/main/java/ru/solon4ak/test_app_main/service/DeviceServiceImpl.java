package ru.solon4ak.test_app_main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solon4ak.test_app_main.model.Device;
import ru.solon4ak.test_app_main.model.Event;
import ru.solon4ak.test_app_main.model.SummaryInfo;
import ru.solon4ak.test_app_main.repository.DeviceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceRepository;

    @Autowired
    public void setDeviceRepository(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public void addDevice(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public Device findDevice(Long id) {
        return deviceRepository.findById(id).get();
    }

    @Override
    public Device updateDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public List<Device> getAllDevicesForProject(Long id) {
        List<Device> devices = deviceRepository.getDeviceByProjectId(id);
        for (Device d : devices) {
            SummaryInfo summaryInfo = d.getSummaryInfo();

            for (Event e : d.getEvents()) {
                switch (e.getType()) {
                    default:
                    case EVENT:
                        summaryInfo.setEventCount(summaryInfo.getEventCount() + 1);
                        break;
                    case WARNING:
                        summaryInfo.setWarningCount(summaryInfo.getWarningCount() + 1);
                        break;
                    case ERROR:
                        summaryInfo.setErrorCount(summaryInfo.getErrorCount() + 1);
                        break;
                }
            }

            if (summaryInfo.getErrorCount() != 0) {
                d.setHasErrors(true);
            }
        }
        return devices;
    }

}
