package com.projeto.cptm.cptm.utils;

import java.io.File;
import java.util.HashMap;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.projeto.cptm.cptm.Login;



@RestController
@RequestMapping("/login")
public class Utils {
    //private Login loginService;

    @GetMapping("login/{user}/{pass}")
    public ResponseEntity<?> lerLogin(@PathVariable("user") String user, @PathVariable("pass") String pass){
        boolean check = verificar(user, pass);
        if(check){
            return ResponseEntity.ok("Login bem-sucedido.");
        }else{
            return ResponseEntity.badRequest().body("Usuário ou senha incorretos.");
        }
    }

    // Supõe-se que esse método seria aprimorado para verificar os dados de login corretamente
    public boolean verificar(String usuario, String password){
        try {
            // Carregar o arquivo JSON contendo as credenciais
            File file = new ClassPathResource("static/login.json").getFile();

            // Criar o ObjectMapper para desserializar o arquivo JSON
            ObjectMapper mapper = new ObjectMapper();
            @SuppressWarnings("unchecked")
            HashMap<String, String> credenciais = mapper.readValue(file, HashMap.class);

            // Obter usuário e senha do arquivo JSON
            String userJson = credenciais.get("user");
            String passJson = credenciais.get("pass");

            //Verificar se as credenciais fornecidas correspondem às do arquivo JSON
            return usuario.equals(userJson) && password.equals(passJson);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @GetMapping("signup/{user}/{pass}")
    public ResponseEntity<?> lerSignup(@PathVariable("user") String user, @PathVariable("pass") String pass){
        boolean check = verificar(user, pass);
        if(check){
            return ResponseEntity.ok("Login bem-sucedido.");
        }else{
            escreverNoArquivoJson(user, pass);
            return ResponseEntity.ok("Usuário e senha cadastrados.");
        }
    }

    public void escreverNoArquivoJson(String usuario, String senha) {
        try {
            // Define o local do arquivo. Use ClassPathResource para ler e File para escrever.
            File file = new ClassPathResource("static/login.json").getFile();
            
            // Prepara os dados para serem escritos. Neste exemplo, substituímos quaisquer dados existentes.
            HashMap<String, String> credenciais = new HashMap<>();
            credenciais.put("user", usuario);
            credenciais.put("pass", senha);

            // Cria um ObjectMapper e escreve os dados no arquivo
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, credenciais);

            System.out.println("Dados escritos com sucesso no arquivo JSON.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
