package com.crow.scmis.product_service.repository;

import com.crow.scmis.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,String> {
}
