package es.serrapos.inditex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.serrapos.inditex.dto.PriceResponseDto;
import es.serrapos.inditex.service.PriceService;

@RestController
public class PriceController {
	
	@Autowired
	PriceService priceService;
	
	@GetMapping("/product/{id}/price")
	PriceResponseDto getPrice(@PathVariable Long productId) {
		return null;
	}
}
