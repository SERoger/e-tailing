package com.crow.scmis.product_service.service.impl;

import com.crow.scmis.product_service.entity.Category;
import com.crow.scmis.product_service.repository.ICategoryRepository;
import com.crow.scmis.product_service.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        category.setId(UUID.randomUUID().toString());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
