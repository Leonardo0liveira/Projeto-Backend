package com.projeto.cptm.cptm;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "login")
@JsonPropertyOrder({"user", "pass"})
public class Login {
    private String user;
    private String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @JsonGetter("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonGetter("pass")
    public String getPass() {
        return pass;
    }

    @JsonProperty("pass")
    public void setPass(String pass) {
        this.pass = pass;
    }
}
