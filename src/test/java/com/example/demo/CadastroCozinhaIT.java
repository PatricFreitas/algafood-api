package com.example.demo;

import org.flywaydb.core.Flyway;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
@TestPropertySource("/application-test.properties")
class CadastroCozinhaIT {
	
	@LocalServerPort
	private int port;
	
	@BeforeAll
	public void allSetup() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";
	}
	
	
	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas(){
		
		
		RestAssured.given()						
			.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveConter4Cozinhas_QuandoConsultarCozinhas(){		
		
		RestAssured.given()
			.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.body("nome", Matchers.hasSize(4))
				.body("nome", Matchers.hasItems("Indiana", "Tailandesa"));
				
	}
	
	@Test
	public void deveRetornarStatus201_QuandoCadastrarCozinha() {
		RestAssured.given()
			.body("{ \"nome\": \"Chinesa\" }")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());
			
	}
}
	