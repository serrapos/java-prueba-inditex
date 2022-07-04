package es.serrapos.inditex.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.serrapos.inditex.domain.Rate;

@DataJpaTest
public class RateRepositoryTest {
	
	@Autowired
    RateRepository rateRepository;

    @Test
    public void getRate() throws Exception {
    	assertThat(rateRepository.findById(1l).isPresent()).isTrue();
    }

}
