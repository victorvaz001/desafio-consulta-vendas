package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleMinDTO {

    private Long id;
    private Double amount;
    private LocalDate date;
    private String sellerName; // Adicionando o nome do vendedor
    private Double total;

    public SaleMinDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }
    
    public SaleMinDTO(Long id, Double amount, LocalDate date, String sellerName) { // Adicionando o nome do vendedor ao construtor
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.sellerName = sellerName; // Definindo o nome do vendedor
    }

    public SaleMinDTO(Sale entity) {
        id = entity.getId();
        amount = entity.getAmount();
        date = entity.getDate();
        sellerName = entity.getSeller().getName(); // Obtendo o nome do vendedor da entidade Sale
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSellerName() { // Adicionando método para obter o nome do vendedor
        return sellerName;
    }
}
