package com.crow.scmis.inventory_service.service.impl;

import com.crow.scmis.inventory_service.entity.LineItem;
import com.crow.scmis.inventory_service.repository.ILineItemRepository;
import com.crow.scmis.inventory_service.service.ILineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineItemServiceImpl implements ILineItemService {
    @Autowired
    private ILineItemRepository lineItemRepository;


    @Override
    public LineItem create(LineItem lineItem) {
        return lineItemRepository.save(lineItem);
    }

    @Override
    public List<LineItem> getAll() {
        return lineItemRepository.findAll();
    }
}
