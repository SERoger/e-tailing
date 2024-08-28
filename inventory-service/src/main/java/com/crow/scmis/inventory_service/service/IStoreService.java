package com.crow.scmis.inventory_service.service;

import com.crow.scmis.inventory_service.entity.Store;

import java.util.List;

public interface IStoreService {
    public Store create(Store store);
    public List<Store> getAll();
}
