package com.projeto.cptm.cptm.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileWriter {

    private final String filePath;

    public JsonFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeLogin(String user, String pass) {
        try {
            // Create a HashMap to represent the login data
            HashMap<String, String> loginData = new HashMap<>();
            loginData.put("user", user);
            loginData.put("pass", pass);

            // Use ObjectMapper to write the login data to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(loginData);

            // Write the JSON string to the file
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(json);
            fileWriter.close();

            System.out.println("Login data written to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing login data to file: " + e.getMessage());
        }
    }
}
