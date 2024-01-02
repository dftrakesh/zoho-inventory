package io.zohoinventory.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static DateTimeFormatter dateFormatte = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return LocalDateTime.parse(jsonParser.getText(), dateFormatte);
    }
}
