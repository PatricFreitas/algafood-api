package com.example.demo;

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

import com.example.demo.domain.model.Cozinha;
import com.example.demo.domain.repository.CozinhaRepository;
import com.example.demo.util.DatabaseCleaner;
import com.example.demo.util.ResourceUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
@TestPropertySource("/application-test.properties")
class CadastroCozinhaIT {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private DatabaseCleaner databaseCleaner;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	private static final Integer ID_COZINHA_INEXISTENTE = 9999;
	
	private Integer totalCozinhasInseridas;
	private Cozinha cozinhaIndiana;	
	private String jsonCozinhaChinesa;
	
	@BeforeAll
	public void allSetup() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";			
		
		jsonCozinhaChinesa = ResourceUtils.getContentFromResource("/json/cozinha.json");
	}
	
	@BeforeEach
	public void eachSetup() {		
		databaseCleaner.clearTables();
		prepararDados();
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
	public void deveConterNumeroDeCozinhasInseridas_QuandoConsultarCozinhas(){		
		
		RestAssured.given()
			.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.body("nome", Matchers.hasSize(totalCozinhasInseridas));			
	}
	
	@Test
	public void deveRetornarStatus201_QuandoCadastrarCozinha() {		
		
		RestAssured.given()
			.body(jsonCozinhaChinesa)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());
			
	}
	
	@Test
	public void deveRetornarRespostaEStatusCorretos_QuandoConsultarCozinhaExistente() {
		RestAssured.given()
			.pathParam("cozinhaId", cozinhaIndiana.getId())
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(HttpStatus.OK.value())
			.body("nome", Matchers.equalTo(cozinhaIndiana.getNome()));
	}
	
	@Test
	public void deveRetornarStatus404_QuandoConsultarCozinhaInexistente() {
		RestAssured.given()
			.pathParam("cozinhaId", ID_COZINHA_INEXISTENTE)
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	private void prepararDados() {
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Tailandesa");
		cozinhaRepository.save(cozinha1);
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Indiana");
		cozinhaIndiana = cozinhaRepository.save(cozinha2);
		
		totalCozinhasInseridas = (int) cozinhaRepository.count();;
	}
}
	