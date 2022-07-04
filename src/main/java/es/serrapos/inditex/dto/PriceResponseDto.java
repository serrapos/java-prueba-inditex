package es.serrapos.inditex.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PriceResponseDto {
	
	public Long productId;
	public Long brandId;
	public Long rateId;
	public Date startDate;
	public Date endDate;
	public BigDecimal price;

}
