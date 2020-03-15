package ru.solon4ak.test_app_main.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.solon4ak.test_app_main.model.Device;
import ru.solon4ak.test_app_main.model.Project;
import ru.solon4ak.test_app_main.model.Stats;

import java.io.IOException;

public class ProjectSerializer extends StdSerializer<Project> {

    public ProjectSerializer() {
        this(null);
    }

    public ProjectSerializer(Class<Project> t) {
        super(t);
    }

    @Override
    public void serialize(Project project, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", project.getId());
        jsonGenerator.writeStringField("projectName", project.getName());

        // stats block
        jsonGenerator.writeObjectFieldStart("stats");
        jsonGenerator.writeObjectField("deviceCount", project.getStats().getDeviceCount());
        jsonGenerator.writeObjectField("deviceWithErrors", project.getStats().getDeviceWithErrors());
        jsonGenerator.writeObjectField("stableDevices", project.getStats().getStableDevices());
        jsonGenerator.writeEndObject();

        // devices block
        jsonGenerator.writeArrayFieldStart("devices");
        for (Device d : project.getDevices()) {
            jsonGenerator.writeString(d.getSerial_number());
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();
    }
}
