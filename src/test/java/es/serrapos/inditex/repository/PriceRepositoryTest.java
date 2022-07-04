package es.serrapos.inditex.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.serrapos.inditex.domain.Brand;
import es.serrapos.inditex.domain.Product;

@DataJpaTest
public class PriceRepositoryTest {
	
	@Autowired
    PriceRepository priceRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BrandRepository brandRepository;
		

	@Test
    public void testGetPriceByProduct() throws Exception {
		Optional<Product> product = productRepository.findById(35455l);
		assertThat(product.isPresent()).isTrue();
				
    	assertThat(priceRepository.findByProduct(product.get()).size()).isEqualTo(4);
    }
	
	@Test
    public void testGetPriceByProductAndBrand() throws Exception {
		Optional<Product> product = productRepository.findById(35455l);
		Optional<Brand> brand = brandRepository.findById(1l);
		assertThat(product.isPresent()).isTrue();
		assertThat(brand.isPresent()).isTrue();
				
    	assertThat(priceRepository.findByProductAndBrand(product.get(), brand.get()).size()).isEqualTo(4);
    }
	
    @Test
    public void getPriceByProductAndBrandAndDate() throws Exception {
    	Optional<Product> product = productRepository.findById(35455l);
		Optional<Brand> brand = brandRepository.findById(1l);
		SimpleDateFormat datetimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date dateCase1 = datetimeFormatter.parse("2020-06-14 10:00:00");
		Date dateCase2 = datetimeFormatter.parse("2020-06-14 16:00:00");
		Date dateCase3 = datetimeFormatter.parse("2020-06-14 21:00:00");
		Date dateCase4 = datetimeFormatter.parse("2020-06-15 10:00:00");
		Date dateCase5 = datetimeFormatter.parse("2020-06-15 21:00:00");
		Date dateCase6 = datetimeFormatter.parse("2020-01-01 21:00:00");
		assertThat(product.isPresent()).isTrue();
		assertThat(brand.isPresent()).isTrue();
				
    	assertThat(priceRepository.findFirstByProductAndBrandAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(product.get(), brand.get(), dateCase1, dateCase1).getPrice().floatValue()).isEqualTo(35.50f);
    	assertThat(priceRepository.findFirstByProductAndBrandAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(product.get(), brand.get(), dateCase2, dateCase2).getPrice().floatValue()).isEqualTo(25.45f);
    	assertThat(priceRepository.findFirstByProductAndBrandAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(product.get(), brand.get(), dateCase3, dateCase3).getPrice().floatValue()).isEqualTo(35.50f);
    	assertThat(priceRepository.findFirstByProductAndBrandAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(product.get(), brand.get(), dateCase4, dateCase4).getPrice().floatValue()).isEqualTo(30.50f);
    	assertThat(priceRepository.findFirstByProductAndBrandAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(product.get(), brand.get(), dateCase5, dateCase5).getPrice().floatValue()).isEqualTo(38.95f);
    	assertThat(priceRepository.findFirstByProductAndBrandAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(product.get(), brand.get(), dateCase6, dateCase6)).isNull();
    }
    

}
