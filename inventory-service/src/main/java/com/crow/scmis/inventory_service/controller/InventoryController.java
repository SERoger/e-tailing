package com.crow.scmis.inventory_service.controller;

import com.crow.scmis.inventory_service.entity.LineItem;
import com.crow.scmis.inventory_service.entity.Store;
import com.crow.scmis.inventory_service.service.ILineItemService;
import com.crow.scmis.inventory_service.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private IStoreService storeService;
    private ILineItemService lineItemService;

    @PostMapping("/store")
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        return new ResponseEntity<>(storeService.create(store), HttpStatus.CREATED);
    }

    @GetMapping("/stores")
    public ResponseEntity<List<Store>> getAllStores(){
        return new ResponseEntity<>(storeService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/lineItem")
    public ResponseEntity<LineItem> createLineItem(@RequestBody LineItem lineItem) {
        return new ResponseEntity<>(lineItemService.create(lineItem), HttpStatus.CREATED);
    }

    @GetMapping("/lineItems")
    public ResponseEntity<List<LineItem>> getAllLineItems(){
        return new ResponseEntity<>(lineItemService.getAll(),HttpStatus.OK);
    }
}
