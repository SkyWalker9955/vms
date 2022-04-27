package com.mikelevytskyi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonMapper {

    private static ObjectMapper objectMapper = getObjectMapper();

    private static ObjectMapper getObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        //obj mapper config
        return defaultObjectMapper;
    }

    public static JsonNode parse(String filePath) throws IOException {
        return objectMapper.readTree(new File(filePath));
    }

    public static List<Item> readItems (JsonNode node) {
        try {
            List<Item> items = new ObjectMapper().readValue(

                    String.valueOf(node.get("items")),
                    new TypeReference<List<Item>>() {}

            );

            return items;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
