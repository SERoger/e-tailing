package com.crow.scmis.supply_service.service;

import com.crow.scmis.supply_service.entity.Supply;

import java.util.List;

public interface ISupplyService {
    public Supply create(Supply supply);
    public List<Supply> getAll();
}
