package com.crow.scmis.order_service.service.impl;

import com.crow.scmis.order_service.entity.OrderDetail;
import com.crow.scmis.order_service.repository.IOrderDetailRepository;
import com.crow.scmis.order_service.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        orderDetail.setId(UUID.randomUUID().toString());
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> getAll() {
        return orderDetailRepository.findAll();
    }
}
