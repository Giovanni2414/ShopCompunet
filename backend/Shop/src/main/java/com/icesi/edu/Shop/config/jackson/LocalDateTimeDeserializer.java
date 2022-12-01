package com.icesi.edu.Shop.config.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    public LocalDateTimeDeserializer(){
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String text = p.getText();
        try{
            var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss");
            return LocalDate.from(formatter.parse(text)).atStartOfDay(ZoneOffset.UTC).toLocalDateTime();

        }catch (DateTimeException dateTimeException){
            throw new InvalidFormatException(p ,"", text, LocalDateTime.class);
        }
    }
}
