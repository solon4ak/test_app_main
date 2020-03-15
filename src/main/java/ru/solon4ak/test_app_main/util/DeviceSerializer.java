package ru.solon4ak.test_app_main.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.solon4ak.test_app_main.model.Device;

import java.io.IOException;

public class DeviceSerializer extends StdSerializer<Device> {

    public DeviceSerializer() {
        this(null);
    }

    public DeviceSerializer(Class<Device> t) {
        super(t);
    }

    @Override
    public void serialize(Device device, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject(device.getSerial_number());

        jsonGenerator.writeObjectFieldStart(device.getSerial_number());
        jsonGenerator.writeNumberField("id", device.getId());
        jsonGenerator.writeStringField("serialNumber", device.getSerial_number());
        jsonGenerator.writeNumberField("projectId", device.getProject().getId());
        jsonGenerator.writeBooleanField("hasErrors", device.isHasErrors());

        jsonGenerator.writeObjectFieldStart("summaryInfo");
        jsonGenerator.writeNumberField("eventCount", device.getSummaryInfo().getEventCount());
        jsonGenerator.writeNumberField("warningCount", device.getSummaryInfo().getWarningCount());
        jsonGenerator.writeNumberField("errorCount", device.getSummaryInfo().getErrorCount());
        jsonGenerator.writeEndObject();

        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
    }
}
