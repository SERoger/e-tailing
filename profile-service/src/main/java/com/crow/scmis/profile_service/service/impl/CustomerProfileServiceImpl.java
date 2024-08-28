package com.crow.scmis.profile_service.service.impl;

import com.crow.scmis.profile_service.dto.Order;
import com.crow.scmis.profile_service.entity.CustomerProfile;
import com.crow.scmis.profile_service.feign.OrderInterface;
import com.crow.scmis.profile_service.repository.ICustomerProfileRepository;
import com.crow.scmis.profile_service.service.ICustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerProfileServiceImpl implements ICustomerProfileService {
    @Autowired
    private ICustomerProfileRepository customerProfileRepository;

    @Autowired
    OrderInterface orderInterface;

    @Autowired
    Environment environment;


    @Override
    public CustomerProfile create(CustomerProfile customerProfile) {
        customerProfile.setId(UUID.randomUUID().toString());
        return customerProfileRepository.save(customerProfile);
    }

    @Override
    public List<CustomerProfile> getAll() {
        return customerProfileRepository.findAll();
    }

    @Override
    public List<Order> getOrders() {
        System.out.println(environment.getProperty("local.server.port"));
        return orderInterface.getAllOrdersByCustomerId("7dd3787b-95b6-40b4-b051-b068c1ddfe03").getBody();
    }


}
