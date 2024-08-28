package com.crow.scmis.order_service.repository;

import com.crow.scmis.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order,String> {
    public List<Order> findByCustomerId(String customerId);
}
