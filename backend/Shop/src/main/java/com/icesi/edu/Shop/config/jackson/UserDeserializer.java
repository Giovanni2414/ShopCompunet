package com.icesi.edu.Shop.config.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.icesi.edu.Shop.model.User;

import java.io.IOException;

public class UserDeserializer extends StdDeserializer<User> {

    public UserDeserializer(){
        super(User.class);
    }

    @Override
    public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return null;
    }
}
