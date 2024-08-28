package com.crow.scmis.profile_service.service;


import com.crow.scmis.profile_service.entity.SupplierProfile;

import java.util.List;

public interface ISupplierProfileService {
    public SupplierProfile create(SupplierProfile supplierProfile);
    public List<SupplierProfile> getAll();
}
