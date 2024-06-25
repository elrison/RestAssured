package com.thecat.TestApi;

import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;


public class TestApi {
	
	@Test
	public void cadastro() {
		String url = "https://www.bemol.com.br/login";
		
		String body = "{\"email\": \"elrisonsilva@gmail.com\","
				     + "\"password\": \"%Lr9s0n23\"}";
		
		//GIVEN
		Response response = given().contentType("application/json").body(body).
		//WHEN
				when().post(url);		
		//THEN
		        response.then().statusCode(200);
		
				System.out.println("RETORNO =>  " + response.body().asString());
		
	}
	@Test
	public void login() {
		String url = "http://localhost:3000/login";
		
		String body = "{\"email\": \"fulano@qa.com\","
				     + "\"password\": \"teste\"}";
		
		//GIVEN
		Response response = given().contentType("application/json").body(body).
		//WHEN
				when().post(url);		
		//THEN
		        response.then().statusCode(200);
		
				System.out.println("RETORNO =>  " + response.body().asString());
		
	}
	
	@Test
	public void login_fail() {
		String url = "http://localhost:3000/login";
			
		String body = "{\"email\": \"fulano@qt.com\","
				     + "\"password\": \"teste\"}";
			
		//GIVEN
		Response response = given().contentType("application/json").body(body).
		//WHEN
				when().post(url);		
		//THEN
		        response.then().statusCode(401);
			
				System.out.println("RETORNO =>  " + response.body().asString());
				
			
	}
	@Test
	public void BuscarUsuario() {
		
		String url = "http://localhost:3000/usuarios/0uxuPY0cbmQhpEz1";
		
		
		//GIVEN
		        given().
		//WHEN
				when().get(url).		
		//THEN
		        then().statusCode(200);
	
	}
	@Test
	public void DeletarrUsuarioComCarrinhoCadastrado() {
		
		String url = "http://localhost:3000/usuarios/0uxuPY0cbmQhpEz1";
		
		
		//GIVEN
		        given().
		//WHEN
				when().delete(url).		
		//THEN
		        then().statusCode(400);
		        
		        System.out.println("Não é permitido excluir usuário com carrinho cadastrado");
	
	}
}
