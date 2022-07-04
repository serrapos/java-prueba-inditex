package es.serrapos.inditex.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import es.serrapos.inditex.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
	

}
