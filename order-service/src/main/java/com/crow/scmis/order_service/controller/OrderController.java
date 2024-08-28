package com.crow.scmis.order_service.controller;

import com.crow.scmis.order_service.entity.Order;
import com.crow.scmis.order_service.entity.OrderDetail;
import com.crow.scmis.order_service.service.IOrderDetailService;
import com.crow.scmis.order_service.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping("/orders")
    private ResponseEntity<List<Order>> getOrders(){
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/order")
    private ResponseEntity<Order> createOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.create(order),HttpStatus.CREATED);
    }

    @GetMapping("orderDetails")
    private ResponseEntity<List<OrderDetail>> getOrderDetails(){
        return new ResponseEntity<>(orderDetailService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/orderDetail")
    private ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail){
        return new ResponseEntity<>(orderDetailService.create(orderDetail),HttpStatus.CREATED);
    }

    @PostMapping("/customerOrders")
    private ResponseEntity<List<Order>> getAllOrdersByCustomerId(@RequestParam String customerId){

        return new ResponseEntity<>(orderService.getByCustomerId(customerId), HttpStatus.OK);
    }
}
