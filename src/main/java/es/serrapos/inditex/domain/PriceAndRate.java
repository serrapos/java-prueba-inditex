package es.serrapos.inditex.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PriceAndRate {
	
	public BigDecimal price;
	public Long rateId;
	public Date startDate;
	public Date endDate;
	
	public PriceAndRate(BigDecimal price, Long rateId, Date startDate, Date endDate) {
		super();
		this.price = price;
		this.rateId = rateId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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
	
	
	

}
