package com.crow.scmis.supply_service.controller;

import com.crow.scmis.supply_service.entity.Supply;
import com.crow.scmis.supply_service.entity.SupplyDetail;
import com.crow.scmis.supply_service.service.ISupplyDetailService;
import com.crow.scmis.supply_service.service.ISupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supply")
public class SupplyController {
    @Autowired
    private ISupplyService supplyService;

    @Autowired
    private ISupplyDetailService supplyDetailService;

    @GetMapping("/supplies")
    private ResponseEntity<List<Supply>> getSupplies(){
        return new ResponseEntity<>(supplyService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/supply")
    private ResponseEntity<Supply> createSupply(@RequestBody Supply supply){
        return new ResponseEntity<>(supplyService.create(supply),HttpStatus.CREATED);
    }

    @GetMapping("/supplyDetails")
    private ResponseEntity<List<SupplyDetail>> getSupplyDetails(){
        return new ResponseEntity<>(supplyDetailService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/supplyDetail")
    private ResponseEntity<SupplyDetail> createSupplyDetail(@RequestBody SupplyDetail supplyDetail){
        return new ResponseEntity<>(supplyDetailService.create(supplyDetail),HttpStatus.CREATED);
    }
}
