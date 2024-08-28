package com.crow.scmis.product_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @Column(length = 36)
    private String id;
    @Column(length = 20)
    private String name;
    @Column(length = 50)
    private String description;
    private float price;
    @Column(length = 50)
    private String skuCode;
    private String barCode;
    private float reorderQty;
    private float packedHeight;
    private float packedWeight;
    private float packedWidth;
    private float packedDepth;
    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product() {
    }

    public Product(String id, String name, String description, float price, String skuCode, String barCode, float reorderQty, float packedHeight, float packedWeight, float packedWidth, float packedDepth, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.skuCode = skuCode;
        this.barCode = barCode;
        this.reorderQty = reorderQty;
        this.packedHeight = packedHeight;
        this.packedWeight = packedWeight;
        this.packedWidth = packedWidth;
        this.packedDepth = packedDepth;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public float getReorderQty() {
        return reorderQty;
    }

    public void setReorderQty(float reorderQty) {
        this.reorderQty = reorderQty;
    }

    public float getPackedHeight() {
        return packedHeight;
    }

    public void setPackedHeight(float packedHeight) {
        this.packedHeight = packedHeight;
    }

    public float getPackedWeight() {
        return packedWeight;
    }

    public void setPackedWeight(float packedWeight) {
        this.packedWeight = packedWeight;
    }

    public float getPackedWidth() {
        return packedWidth;
    }

    public void setPackedWidth(float packedWidth) {
        this.packedWidth = packedWidth;
    }

    public float getPackedDepth() {
        return packedDepth;
    }

    public void setPackedDepth(float packedDepth) {
        this.packedDepth = packedDepth;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
