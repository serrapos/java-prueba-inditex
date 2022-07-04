package es.serrapos.inditex.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import es.serrapos.inditex.domain.Rate;

public interface RateRepository extends JpaRepository<Rate, Long> {
	

}
