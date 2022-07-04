package es.serrapos.inditex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.serrapos.inditex.domain.Price;

@SpringBootTest
public class PriceServiceTest {
	
	@Autowired
	PriceService priceService;
	
	@Test
	public void testCalculatePriceByProductAndBrand_ProductNotFound() {
		Exception exception = assertThrows(Exception.class, () -> priceService.calculatePriceByProductAndBrand(1000l, 1000l, new Date()));
		assertEquals("404 NOT_FOUND \"product not found\"", exception.getMessage());
	}
	
	@Test
	public void testCalculatePriceByProductAndBrand_BrandNotFound() {
		Exception exception = assertThrows(Exception.class, () -> priceService.calculatePriceByProductAndBrand(35455l, 1000l, new Date()));
		assertEquals("404 NOT_FOUND \"brand not found\"", exception.getMessage());
	}
	
	@Test
	public void testCalculatePriceByProductAndBrand_PriceNotFound() {
		Exception exception = assertThrows(Exception.class, () -> priceService.calculatePriceByProductAndBrand(35455l, 1l, new Date()));
		assertEquals("404 NOT_FOUND \"price not found\"", exception.getMessage());
	}
	
	@Test
	public void testCalculatePriceByProductAndBrand_Ok() throws Exception{
		SimpleDateFormat datetimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date dateCase1 = datetimeFormatter.parse("2020-06-14 10:00:00");
		Price price = priceService.calculatePriceByProductAndBrand(35455l, 1l, dateCase1);
		assertEquals(price.getPrice().floatValue(), 35.5f);
	}
	
	

}
