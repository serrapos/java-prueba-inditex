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
	
	public PriceResponseDto() {
		super();
	}
	
	public PriceResponseDto(Long productId, Long brandId, Long rateId, Date startDate, Date endDate, BigDecimal price) {
		super();
		this.productId = productId;
		this.brandId = brandId;
		this.rateId = rateId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
