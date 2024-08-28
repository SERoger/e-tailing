package com.crow.scmis.profile_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SUPPLIER")
public class SupplierProfile extends Profile{
    @Column(length = 50)
    private String businessId;

    public SupplierProfile() {
    }

    public SupplierProfile(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
