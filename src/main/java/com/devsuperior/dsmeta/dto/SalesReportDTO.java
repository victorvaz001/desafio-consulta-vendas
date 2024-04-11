package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;

public class SalesReportDTO {
	
	 private Long id;
	    private LocalDate date;
	    private String sellerName;
	    private Double amount;

	    public SalesReportDTO(Sale entity) {
	        id = entity.getId();
	        date = entity.getDate();
	        amount = entity.getAmount();
	        sellerName = entity.getSeller().getName();
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public LocalDate getDate() {
	        return date;
	    }

	    public void setDate(LocalDate date) {
	        this.date = date;
	    }

	    public String getSellerName() {
	        return sellerName;
	    }

	    public void setSellerName(String sellerName) {
	        this.sellerName = sellerName;
	    }

	    public Double getAmount() {
	        return amount;
	    }

	    public void setAmount(Double amount) {
	        this.amount = amount;
	    }
}
