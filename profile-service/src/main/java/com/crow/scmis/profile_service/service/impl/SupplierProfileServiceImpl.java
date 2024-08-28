package com.crow.scmis.profile_service.service.impl;

import com.crow.scmis.profile_service.entity.SupplierProfile;
import com.crow.scmis.profile_service.repository.ISupplierProfileRepository;
import com.crow.scmis.profile_service.service.ISupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class SupplierProfileServiceImpl implements ISupplierProfileService {
    @Autowired
    private ISupplierProfileRepository supplierProfileRepository;

    @Override
    public SupplierProfile create(SupplierProfile supplierProfile) {
        supplierProfile.setId(UUID.randomUUID().toString());
        return supplierProfileRepository.save(supplierProfile);
    }

    @Override
    public List<SupplierProfile> getAll() {
        return supplierProfileRepository.findAll();
    }
}
