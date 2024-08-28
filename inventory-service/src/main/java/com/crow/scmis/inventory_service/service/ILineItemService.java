package com.crow.scmis.inventory_service.service;

import com.crow.scmis.inventory_service.entity.LineItem;
import com.crow.scmis.inventory_service.entity.Store;

import java.util.List;

public interface ILineItemService {
    public LineItem create(LineItem lineItem);
    public List<LineItem> getAll();
}
