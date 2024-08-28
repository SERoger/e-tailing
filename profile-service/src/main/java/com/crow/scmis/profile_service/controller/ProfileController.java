package com.crow.scmis.profile_service.controller;

import com.crow.scmis.profile_service.dto.Order;
import com.crow.scmis.profile_service.entity.CustomerProfile;
import com.crow.scmis.profile_service.entity.SupplierProfile;
import com.crow.scmis.profile_service.service.ICustomerProfileService;
import com.crow.scmis.profile_service.service.ISupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ISupplierProfileService supplierProfileService;

    @Autowired
    private ICustomerProfileService customerProfileService;

    @PostMapping("/supplier")
    public ResponseEntity<SupplierProfile> createSupplier(@RequestBody SupplierProfile profile){
        return new ResponseEntity<>(supplierProfileService.create(profile), HttpStatus.CREATED);
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<SupplierProfile>> getAllSuppliers(){
        return new ResponseEntity<>(supplierProfileService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerProfile> createCustomer(@RequestBody CustomerProfile profile){
        return new ResponseEntity<>(customerProfileService.create(profile), HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerProfile>> getAllCustomers(){
        return new ResponseEntity<>(customerProfileService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/customerOrders")
    public ResponseEntity<List<Order>> getAllCustomerOrders(){
        return new ResponseEntity<>(customerProfileService.getOrders(),HttpStatus.OK);
    }
}
