package com.mikelevytskyi;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonMapperTest {

    private String testFilePath = "/Users/mikelevytskyi/Projects/Maven/vms/update.json";

    @org.junit.jupiter.api.Test
    void parse() {
        try {

            JsonNode node = JsonMapper.parse(testFilePath);
            assertEquals(node.toString(), "{\"config\":{\"rows\":4,\"columns\":\"8\"},\"items\":[{\"name\":\"Snickers\",\"amount\":10,\"price\":\"$1.35\"},{\"name\":\"Hersheys\",\"amount\":10,\"price\":\"$2.25\"},{\"name\":\"Hersheys Almond\",\"amount\":10,\"price\":\"$1.80\"},{\"name\":\"Hersheys Special Dark\",\"amount\":10,\"price\":\"$1.75\"},{\"name\":\"Reese's\",\"amount\":10,\"price\":\"$1.05\"},{\"name\":\"Nutrageous\",\"amount\":10,\"price\":\"$1.30\"},{\"name\":\"Baby Ruth\",\"amount\":10,\"price\":\"$2.50\"},{\"name\":\"Milky Way\",\"amount\":10,\"price\":\"$1.00\"},{\"name\":\"M&M\",\"amount\":10,\"price\":\"$1.25\"}]}");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}