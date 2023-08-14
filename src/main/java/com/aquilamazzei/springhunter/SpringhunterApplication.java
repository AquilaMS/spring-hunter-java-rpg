package com.aquilamazzei.springhunter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Hunter - SWAGGER", version = "1.0", description = "Backend for a roguelike game"))
public class SpringhunterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringhunterApplication.class, args);
	}

}
