package com.crow.scmis.order_service.service.impl;

import com.crow.scmis.order_service.entity.Order;
import com.crow.scmis.order_service.repository.IOrderRepository;
import com.crow.scmis.order_service.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    Environment environment;

    @Override
    public Order create(Order order) {
        order.setId(UUID.randomUUID().toString());
        order.setDateTimeOrdered(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getByCustomerId(String customerId) {
        System.out.println(environment.getProperty("local.server.port"));
        return orderRepository.findAll();
    }

}
