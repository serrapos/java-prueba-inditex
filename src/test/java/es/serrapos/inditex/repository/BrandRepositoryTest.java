package es.serrapos.inditex.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.serrapos.inditex.domain.Brand;

@DataJpaTest
public class BrandRepositoryTest {
	
	@Autowired
    BrandRepository brandRepository;

    @Test
    public void getBrandTest() throws Exception {
    	assertThat(brandRepository.findById(1l).isPresent()).isTrue();
    }

}
