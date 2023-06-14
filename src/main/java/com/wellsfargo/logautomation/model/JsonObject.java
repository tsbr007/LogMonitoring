package com.wellsfargo.logautomation.model;

import java.util.HashMap;
import java.util.Map;

public class JsonObject {
    private Map<String, Object> properties;

    public JsonObject() {
        properties = new HashMap<>();
    }

    public void addProperty(String key, Object value) {
        properties.put(key, value);
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    public int size() {
        return properties.size();
    }

    public boolean isEmpty() {
        return properties.isEmpty();
    }

    @Override
    public String toString() {
        return properties.toString();
    }
}

