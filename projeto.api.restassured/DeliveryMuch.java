package projeto.api.restassured;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeliveryMuch {

	@Test
	public void statusCodeDezMil() {
		//NESTA LINHA USAMOS O RESTASSURED PARA SE COMUNICAR COM A API GET 
		Response response = RestAssured.get("http://challengeqa.staging.devmuch.io/10000");
		
		//USAMOS O RESTASSURED PARA GUARDAR O VALOR DO STATUSCODERETORNADO PELA API EM UMA VARIÁVEL
		int code = response.getStatusCode();
		
		//USAMOS O JUNIT PARA VALIDAR SE O RETORNO DO STATUS DA API É IGUAL AO RETORNO ESPERADO
		assertEquals(200, code);
	}
	
	@Test
	public void bodyResponseMenosDezMil() {
		
		Response response = RestAssured.get("http://challengeqa.staging.devmuch.io/-10000");
		String bodyResponse = response.asPrettyString();
	    String retornoEsperado = "dez mil";
	    System.out.println(bodyResponse.contains(retornoEsperado));
		
		
	}
	
	
	
}
