package com.crow.scmis.order_service.service;

import com.crow.scmis.order_service.entity.Order;

import java.util.List;

public interface IOrderService {
    public Order create(Order order);
    public List<Order> getAll();
    public List<Order> getByCustomerId(String customerId);
}
