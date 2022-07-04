package es.serrapos.inditex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import es.serrapos.inditex.domain.Product;
import es.serrapos.inditex.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product getProduct(Long id) throws ResponseStatusException{
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()){
			return product.get();			
		} else {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "product not found"
					);
		}
	}
	

}
