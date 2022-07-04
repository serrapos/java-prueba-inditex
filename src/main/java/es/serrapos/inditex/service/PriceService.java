package es.serrapos.inditex.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import es.serrapos.inditex.domain.Brand;
import es.serrapos.inditex.domain.Price;
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
	
	public Price calculatePriceByProductAndBrand(Long productId, Long brandId, Date dateOfPurchase) throws ResponseStatusException{
		Product product = productService.getProduct(productId);
		Brand brand = brandService.getBrand(brandId);
		Price price = getPriceByProductAndBrand(product, brand, dateOfPurchase);
		if (price == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "price not found"
					);
		}
		return price;
	}
	
	public Price getPriceByProductAndBrand(Product product, Brand brand, Date dateOfPurchase) {
		return priceRepository.findFirstByProductAndBrandAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(product, brand, dateOfPurchase, dateOfPurchase);
	}
	

}
