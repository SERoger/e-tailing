package com.crow.scmis.supply_service.service.impl;

import com.crow.scmis.supply_service.entity.Supply;
import com.crow.scmis.supply_service.repository.ISupplyRepository;
import com.crow.scmis.supply_service.service.ISupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupplyServiceImpl implements ISupplyService {
    @Autowired
    private ISupplyRepository orderRepository;

    @Override
    public Supply create(Supply supply) {
        supply.setId(UUID.randomUUID().toString());
        return orderRepository.save(supply);
    }

    @Override
    public List<Supply> getAll() {
        return orderRepository.findAll();
    }
}
