package ru.solon4ak.test_app_main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.solon4ak.test_app_main.model.Device;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> getDeviceByProjectId(Long id);
}
