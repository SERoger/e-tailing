package com.crow.scmis.supply_service.service;

import com.crow.scmis.supply_service.entity.SupplyDetail;

import java.util.List;

public interface ISupplyDetailService {
    public SupplyDetail create(SupplyDetail supplyDetail);
    public List<SupplyDetail> getAll();
}
