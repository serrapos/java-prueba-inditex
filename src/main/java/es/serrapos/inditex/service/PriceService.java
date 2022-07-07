package es.serrapos.inditex.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import es.serrapos.inditex.domain.Brand;
import es.serrapos.inditex.domain.PriceAndRate;
import es.serrapos.inditex.domain.Product;
import es.serrapos.inditex.repository.PriceRepository;

@Service
public class PriceService {
	
	@Autowired
	PriceRepository priceRepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	BrandService brandService;
	
	public PriceAndRate calculatePriceByProductAndBrand(Long productId, Long brandId, Date dateOfPurchase) throws ResponseStatusException{
		List<PriceAndRate> results = priceRepository.getPriceByProductAndBrand(productId, brandId, dateOfPurchase);
		if (results.size() > 0) {
			return results.get(0);
		} else {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "price not found"
					);
		}
	}
	

}
