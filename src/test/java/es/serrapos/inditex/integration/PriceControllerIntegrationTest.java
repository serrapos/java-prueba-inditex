package es.serrapos.inditex.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.serrapos.inditex.InditexApplication;
import es.serrapos.inditex.dto.PriceResponseDto;

@SpringBootTest(classes = InditexApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class PriceControllerIntegrationTest {
	
	@LocalServerPort
	private int port;
 
	@Autowired
	private TestRestTemplate restTemplate;
 
	@Test
	public void testGetPrice_ProductNotFound() 
	{
		Long product = 1l;
		Long brand = 1l;
		String dateToPurchase = "2020-06-14-10.00.00";
				
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("http://localhost:" + port + "/product/" + product + "/price?brand="+brand+"&date="+dateToPurchase, PriceResponseDto.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	public void testGetPrice_BrandNotFound() 
	{
		Long product = 35455l;
		Long brand = 100l;
		String dateToPurchase = "2020-06-14-10.00.00";
				
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("http://localhost:" + port + "/product/" + product + "/price?brand="+brand+"&date="+dateToPurchase, PriceResponseDto.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	public void testGetPrice_PriceNotFound() 
	{
		Long product = 35455l;
		Long brand = 1l;
		String dateToPurchase = "2022-06-14-10.00.00";
				
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("http://localhost:" + port + "/product/" + product + "/price?brand="+brand+"&date="+dateToPurchase, PriceResponseDto.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	public void testGetPrice_Case1() 
	{
		Long product = 35455l;
		Long brand = 1l;
		String dateToPurchase = "2020-06-14-10.00.00";
				
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("http://localhost:" + port + "/product/" + product + "/price?brand="+brand+"&date="+dateToPurchase, PriceResponseDto.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35.50f, response.getBody().getPrice().floatValue());
	}
	
	@Test
	public void testGetPrice_Case2() 
	{
		Long product = 35455l;
		Long brand = 1l;
		String dateToPurchase = "2020-06-14-16.00.00";
				
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("http://localhost:" + port + "/product/" + product + "/price?brand="+brand+"&date="+dateToPurchase, PriceResponseDto.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(25.45f, response.getBody().getPrice().floatValue());
	}
	
	@Test
	public void testGetPrice_Case3() 
	{
		Long product = 35455l;
		Long brand = 1l;
		String dateToPurchase = "2020-06-14-21.00.00";
				
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("http://localhost:" + port + "/product/" + product + "/price?brand="+brand+"&date="+dateToPurchase, PriceResponseDto.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35.50f, response.getBody().getPrice().floatValue());
	}
	
	@Test
	public void testGetPrice_Case4() 
	{
		Long product = 35455l;
		Long brand = 1l;
		String dateToPurchase = "2020-06-15-10.00.00";
				
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("http://localhost:" + port + "/product/" + product + "/price?brand="+brand+"&date="+dateToPurchase, PriceResponseDto.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(30,50f, response.getBody().getPrice().floatValue());
	}
	
	@Test
	public void testGetPrice_Case5() 
	{
		Long product = 35455l;
		Long brand = 1l;
		String dateToPurchase = "2020-06-16-21.00.00";
				
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("http://localhost:" + port + "/product/" + product + "/price?brand="+brand+"&date="+dateToPurchase, PriceResponseDto.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(38.95f, response.getBody().getPrice().floatValue());
	}
	

}
