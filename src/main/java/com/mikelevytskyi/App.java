package com.mikelevytskyi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class App
{
    public static void main( String[] args ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Parser il = mapper.readValue(new File("/Users/mikelevytskyi/Projects/" +
                "Maven/vms/update-instructions.json") , Parser.class);

        System.out.println(il.getConfig().toString());

    }
}
