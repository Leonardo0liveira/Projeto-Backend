package com.projeto.cptm.cptm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/")
public class Utils {

    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("/login/{user}/{pass}")
    public ResponseEntity<?> lerLogin(@PathVariable("user") String user, @PathVariable("pass") String pass) {
        boolean check = verificar(user, pass);
        if (check) {
            return ResponseEntity.ok("Login bem-sucedido.");
        } else {
            return ResponseEntity.badRequest().body("Usuário ou senha incorretos.");
        }
    }

    public boolean verificar(String usuario, String password) {
        try {
            File file = resourceLoader.getResource("classpath:static/login.json").getFile();
            ObjectMapper mapper = new ObjectMapper();
            @SuppressWarnings("unchecked")
            HashMap<String, String> credenciais = mapper.readValue(file, HashMap.class);
            String userJson = credenciais.get("user");
            String passJson = credenciais.get("pass");
            return usuario.equals(userJson) && password.equals(passJson);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/signup/{user}/{pass}")
    public ResponseEntity<?> lerSignup(@PathVariable("user") String user, @PathVariable("pass") String pass) throws IOException {
        boolean check = verificar(user, pass);
        if (check) {
            return ResponseEntity.badRequest().body("Usuário já existe.");
        } else {
            escreverNoArquivoJson(user, pass);
            return ResponseEntity.ok("Usuário e senha cadastrados.");
        }
    }

    /* public void escreverNoArquivoJson(String usuario, String senha) {
        try {
            File file = resourceLoader.getResource("classpath:static/login.json").getFile();
            HashMap<String, String> credenciais = new HashMap<>();
            credenciais.put("user", usuario);
            credenciais.put("pass", senha);
            ObjectMapper mapper = new ObjectMapper();
            // Convert HashMap to JSON and write to file
            mapper.writeValue(file, credenciais);
            System.out.println("Dados escritos com sucesso no arquivo JSON.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    } */
    
    public void escreverNoArquivoJson(String usuario, String senha) throws IOException {
        String filePath = resourceLoader.getResource("classpath:static/login.json").getFile().getPath();
        JsonFileWriter jsonFileWriter = new JsonFileWriter(filePath);
        jsonFileWriter.writeLogin(usuario, senha);
    }
    
}