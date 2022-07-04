package es.serrapos.inditex.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.serrapos.inditex.domain.Product;

@DataJpaTest
public class ProductRepositoryTest {
	
	@Autowired
    ProductRepository productRepository;

    @Test
    public void getProduct() throws Exception {
    	assertThat(productRepository.findById(35455l).isPresent()).isTrue();
    }

}
