package es.serrapos.inditex.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.serrapos.inditex.domain.Brand;
import es.serrapos.inditex.domain.Price;
import es.serrapos.inditex.domain.PriceAndRate;
import es.serrapos.inditex.domain.Product;

public interface PriceRepository extends JpaRepository<Price, Long> {
	
	List<Price> findByProduct(Product product);
	List<Price> findByProductAndBrand(Product product, Brand brand);
	Price findFirstByProductAndBrandAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(Product product, Brand brand, Date dateToStart, Date dateToEnd);
	
	@Query(value = "SELECT new es.serrapos.inditex.domain.PriceAndRate(p.price, p.rate.id, p.startDate, p.endDate) FROM Price p WHERE p.product.id = ?1 AND p.brand.id = ?2 AND p.startDate <= ?3 AND p.endDate > ?3 ORDER BY priority desc")
	List<PriceAndRate> getPriceByProductAndBrand(Long productId, Long brandId, Date datePurchase);
}
