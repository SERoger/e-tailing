package com.crow.scmis.supply_service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class SupplyDetail {
    @Id
    @Column(length = 36)
    private String id;
    private float quantity;
    private LocalDate expectedDate;
    private LocalDate arrivalDate;
    //From Product Service
    private String productId;
    @ManyToOne
    @JoinColumn(name = "supply_id")
    private Supply supply;

    public SupplyDetail() {
    }

    public SupplyDetail(String id, float quantity, LocalDate expectedDate, LocalDate arrivalDate, String productId, Supply supply) {
        this.id = id;
        this.quantity = quantity;
        this.expectedDate = expectedDate;
        this.arrivalDate = arrivalDate;
        this.productId = productId;
        this.supply = supply;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(LocalDate expectedDate) {
        this.expectedDate = expectedDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Supply getOrder() {
        return supply;
    }

    public void setOrder(Supply supply) {
        this.supply = supply;
    }
}
