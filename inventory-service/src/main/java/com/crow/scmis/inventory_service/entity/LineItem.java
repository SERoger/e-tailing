package com.crow.scmis.inventory_service.entity;

import jakarta.persistence.*;

@Entity
public class LineItem {
    @Id
    private String id;
    @Column(unique = true,nullable = false)
    private String productId;
    private float availableQty;
    private float minimumStockLevel;
    private float maximumStockLevel;
    private float reorderPoint;
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    public LineItem() {
    }

    public LineItem(String id, String productId, float availableQty, float minimumStockLevel, float maximumStockLevel, float reorderPoint, Store store) {
        this.id = id;
        this.productId = productId;
        this.availableQty = availableQty;
        this.minimumStockLevel = minimumStockLevel;
        this.maximumStockLevel = maximumStockLevel;
        this.reorderPoint = reorderPoint;
        this.store = store;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public float getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(float availableQty) {
        this.availableQty = availableQty;
    }

    public float getMinimumStockLevel() {
        return minimumStockLevel;
    }

    public void setMinimumStockLevel(float minimumStockLevel) {
        this.minimumStockLevel = minimumStockLevel;
    }

    public float getMaximumStockLevel() {
        return maximumStockLevel;
    }

    public void setMaximumStockLevel(float maximumStockLevel) {
        this.maximumStockLevel = maximumStockLevel;
    }

    public float getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(float reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
