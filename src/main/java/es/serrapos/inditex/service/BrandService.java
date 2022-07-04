package es.serrapos.inditex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import es.serrapos.inditex.domain.Brand;
import es.serrapos.inditex.repository.BrandRepository;

@Service
public class BrandService {
	
	@Autowired
	BrandRepository brandRepository;
	
	public Brand getBrand(Long id) throws ResponseStatusException{
		Optional<Brand> product = brandRepository.findById(id);
		if (product.isPresent()){
			return product.get();			
		} else {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "brand not found"
					);
		}
	}

}
