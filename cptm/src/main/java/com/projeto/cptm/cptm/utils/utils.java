package com.projeto.cptm.cptm.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.cptm.cptm.Login;



@RestController
@RequestMapping("/login")
public class utils {
    private String usuario;
    private String password;
    private Login login;

    private void lerLogin(String usuario, String password, Login login){
        this.usuario = usuario;
        this.password = password;
        this.login = login;
    }

    @GetMapping("login/{user}/{pass}") 
    public void ler(@PathVariable("user") String user, @PathVariable("pass") String pass){
        boolean check = verificar(login.getUser(), login.getPass());
        if(check == true){
            //direciona/chama alguma coisa
        }else{
            //criar ou direcionar msg de erro
        }
    }

    //criar metodo que vai definir um local pra ler e salvar json
    public boolean verificar(String usuario, String password){
        //verificar se usuario e senha recebido e igual do arquivo json
        return true;
    }

    //

}
