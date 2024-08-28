package com.crow.scmis.product_service.service;

import com.crow.scmis.product_service.entity.Category;

import java.util.List;

public interface ICategoryService {
    public Category create(Category category);
    public List<Category> getAll();
}
