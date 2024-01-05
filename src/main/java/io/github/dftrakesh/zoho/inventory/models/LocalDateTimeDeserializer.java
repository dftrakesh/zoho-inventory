package io.github.dftrakesh.zoho.inventory.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    @Override
    @SneakyThrows
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return LocalDateTime.parse(jsonParser.getText(), dateFormat);
    }
}
