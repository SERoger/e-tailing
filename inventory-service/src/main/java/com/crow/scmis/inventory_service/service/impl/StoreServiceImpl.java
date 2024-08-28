package com.crow.scmis.inventory_service.service.impl;

import com.crow.scmis.inventory_service.entity.Store;
import com.crow.scmis.inventory_service.repository.IStoreRepository;
import com.crow.scmis.inventory_service.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements IStoreService {
    @Autowired
    private IStoreRepository storeRepository;

    @Override
    public Store create(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }
}
