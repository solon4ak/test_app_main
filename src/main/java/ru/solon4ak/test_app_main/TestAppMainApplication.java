package ru.solon4ak.test_app_main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.solon4ak.test_app_main.model.Device;
import ru.solon4ak.test_app_main.model.Project;
import ru.solon4ak.test_app_main.repository.DeviceRepository;
import ru.solon4ak.test_app_main.repository.EventRepository;
import ru.solon4ak.test_app_main.repository.ProjectRepository;
import ru.solon4ak.test_app_main.service.DeviceService;
import ru.solon4ak.test_app_main.service.EventService;
import ru.solon4ak.test_app_main.service.ProjectService;
import ru.solon4ak.test_app_main.util.DateConverter;
import ru.solon4ak.test_app_main.util.TestDataInit;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TestAppMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestAppMainApplication.class, args);
    }

    @Bean(initMethod = "init")
    @PostConstruct
    public TestDataInit populateDB() {
        return new TestDataInit();
    }

    @Bean
    public DateConverter getDateConverter() {
        return new DateConverter();
    }

}
