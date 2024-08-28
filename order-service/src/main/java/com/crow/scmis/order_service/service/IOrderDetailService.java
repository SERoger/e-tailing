package com.crow.scmis.order_service.service;

import com.crow.scmis.order_service.entity.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    public OrderDetail create(OrderDetail orderDetail);
    public List<OrderDetail> getAll();
}
