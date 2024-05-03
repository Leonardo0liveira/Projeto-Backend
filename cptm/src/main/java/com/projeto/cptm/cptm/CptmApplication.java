package com.projeto.cptm.cptm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.projeto.cptm.cptm", "com.projeto.cptm.cptm.utils"}) // Add your package names here
public class CptmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CptmApplication.class, args);
	}

}
