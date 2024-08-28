package com.crow.scmis.supply_service.service.impl;

import com.crow.scmis.supply_service.entity.SupplyDetail;
import com.crow.scmis.supply_service.repository.ISupplyDetailRepository;
import com.crow.scmis.supply_service.service.ISupplyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupplyDetailServiceImpl implements ISupplyDetailService {

    @Autowired
    private ISupplyDetailRepository supplyDetailRepository;

    @Override
    public SupplyDetail create(SupplyDetail supplyDetail) {
        supplyDetail.setId(UUID.randomUUID().toString());
        return supplyDetailRepository.save(supplyDetail);
    }

    @Override
    public List<SupplyDetail> getAll() {
        return supplyDetailRepository.findAll();
    }
}
