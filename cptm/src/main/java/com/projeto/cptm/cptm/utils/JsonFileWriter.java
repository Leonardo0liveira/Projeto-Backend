package com.projeto.cptm.cptm.utils;
import java.io.*;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

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
    public void writeLinhas(String id, String nome, String estacoes) {
        try {
            //InputStream inputStream = new FileInputStream("/Users/stefano/Documents/Ibmec/Back End/Eclipse Workspace Projeto/Projeto-Backend/cptm/src/main/resources/static/linhas.json");
            // Create a HashMap to represent the linhas data
            HashMap<String, String> linhasData = new HashMap<>();
            linhasData.put("id", id);
            linhasData.put("nome", nome);
            linhasData.put("estacoes", estacoes);

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(linhasData);

            // Write the JSON string to the file
            //if (inputStream.read() == -1) {
                //File linhas = new File(filePath);
                //linhas.createNewFile();
                //writeLinhas(f, id, nome, estacoes);
            //}else{
                FileWriter fileWriter = new FileWriter(filePath);
                fileWriter.write(json);
                fileWriter.close();
                System.out.println("Linhas data written to file: " + filePath);
            //}
            

            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing linhas data to file: " + e.getMessage());
        }
    }
}
