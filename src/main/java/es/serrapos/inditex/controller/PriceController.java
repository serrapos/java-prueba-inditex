package es.serrapos.inditex.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.serrapos.inditex.domain.Price;
import es.serrapos.inditex.dto.PriceResponseDto;
import es.serrapos.inditex.service.PriceService;

@RestController
public class PriceController {
	
	@Autowired
	PriceService priceService;
	
	@GetMapping("/product/{productId}/price")
	PriceResponseDto getPrice(@PathVariable Long productId, @RequestParam(name = "brand") Long brandId, @RequestParam(name="date") @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss") Date datePurchase) {
		Price price = priceService.calculatePriceByProductAndBrand(productId, brandId, datePurchase);
		return convertPriceToDto(price);
	}
	
	private PriceResponseDto convertPriceToDto(Price price) {
		PriceResponseDto response = new PriceResponseDto(price.getProduct().getId(), price.getBrand().getId(), price.getRate().getId(), price.getStartDate(), price.getEndDate(), price.getPrice());
		return response;
	}
}
