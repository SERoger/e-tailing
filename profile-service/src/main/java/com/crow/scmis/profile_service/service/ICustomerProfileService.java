package com.crow.scmis.profile_service.service;

import com.crow.scmis.profile_service.dto.Order;
import com.crow.scmis.profile_service.entity.CustomerProfile;

import java.util.List;

public interface ICustomerProfileService {
    public CustomerProfile create(CustomerProfile customerProfile);
    public List<CustomerProfile> getAll();
    public List<Order> getOrders();
}
