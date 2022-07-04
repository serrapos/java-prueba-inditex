package es.serrapos.inditex.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.serrapos.inditex.domain.Brand;
import es.serrapos.inditex.domain.Price;
import es.serrapos.inditex.domain.Product;

public interface PriceRepository extends JpaRepository<Price, Long> {
	
	List<Price> findByProduct(Product product);
	List<Price> findByProductAndBrand(Product product, Brand brand);
	Price findFirstByProductAndBrandAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(Product product, Brand brand, Date dateToStart, Date dateToEnd);

}
