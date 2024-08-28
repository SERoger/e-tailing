package com.crow.scmis.profile_service.feign;

import com.crow.scmis.profile_service.dto.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient("ORDER-SERVICE/order")
public interface OrderInterface {

    @PostMapping("/customerOrders")
    public ResponseEntity<List<Order>> getAllOrdersByCustomerId(@RequestParam String customerId);

}
