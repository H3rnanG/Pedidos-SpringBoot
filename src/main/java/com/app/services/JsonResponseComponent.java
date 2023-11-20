package com.app.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Component;

@Component
public class JsonResponseComponent {

    private static JsonResponseComponent jsonResponseComponent;
    private JsonNode jsonResponse = null;
    private ObjectMapper objectMapper;

    private JsonResponseComponent() {
        objectMapper = new ObjectMapper();
    }

    public static synchronized JsonResponseComponent getInstance() {
        if (jsonResponseComponent == null) {
            jsonResponseComponent = new JsonResponseComponent();
        }
        return jsonResponseComponent;
    }

    public JsonNode getJsonResponse() {
        return jsonResponse;
    }

    public void clearJsonResponse() {
        jsonResponse = null;
    }

    public void addProperty(String key, Object value) {
        if (jsonResponse == null) {
            jsonResponse = objectMapper.createObjectNode();
        }
        ((ObjectNode) jsonResponse).put(key, String.valueOf(value));
    }

}