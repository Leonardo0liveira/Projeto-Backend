package com.projeto.cptm.cptm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.cptm.cptm.Estacao;

@RestController
@RequestMapping("/linhas")
public class LinhaController {

    private final ResourceLoader resourceLoader;

    public LinhaController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("/{id}/{nome}/{estacoes}")
    @ResponseBody
    public String saveLinhas(@PathVariable String id, @PathVariable String nome, @PathVariable String estacoes) throws IOException {
        try {
            String filePath = resourceLoader.getResource("classpath:static/linhas.json").getFile().getPath();
            File linhasFile = new File(filePath);
            InputStream inputStream = new FileInputStream(linhasFile);
            // If file doesn't exist, create a new one
            if (linhasFile.createNewFile()) {
                System.out.println(linhasFile);
                JsonFileWriter jsonFileWriter = new JsonFileWriter(filePath);
                jsonFileWriter.writeLinhas(id, nome, estacoes);
            } 
            // If file exists, rewrite it
            else {
                String existingFilePath = resourceLoader.getResource("classpath:static/linhas.json").getFile().getPath();
                JsonFileWriter jsonFileWriter = new JsonFileWriter(existingFilePath);
                jsonFileWriter.writeLinhas(id, nome, estacoes);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return "Data saved.";
    }
}
