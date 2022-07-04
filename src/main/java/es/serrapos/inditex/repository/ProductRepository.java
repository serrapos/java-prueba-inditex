package es.serrapos.inditex.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import es.serrapos.inditex.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	

}
