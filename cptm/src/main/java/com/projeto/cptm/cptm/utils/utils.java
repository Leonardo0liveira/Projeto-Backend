package com.projeto.cptm.cptm.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class utils {
    private String usuario;
    private String password;

    private void lerLogin(String usuario, String password){
        this.usuario = usuario;
        this.password = password;
    }

    @GetMapping("/login:{user}{pass}")
    public boolean ler(@PathVariable(name = "user", pass = "pass") String user, String pass){
        
        return true;
    }
}
