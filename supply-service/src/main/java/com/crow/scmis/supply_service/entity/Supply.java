package com.crow.scmis.supply_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Supply {
    @Id
    @Column(length = 36)
    private String id;
    private LocalDateTime dateTimeSold;
    @OneToMany(mappedBy = "supply")
    private List<SupplyDetail> supplyDetails;

    public Supply() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTimeSold() {
        return dateTimeSold;
    }

    public void setDateTimeSold(LocalDateTime dateTimeSold) {
        this.dateTimeSold = dateTimeSold;
    }

    public List<SupplyDetail> getSupplyDetails() {
        return supplyDetails;
    }

    public void setSupplyDetails(List<SupplyDetail> supplyDetails) {
        this.supplyDetails = supplyDetails;
    }
}
