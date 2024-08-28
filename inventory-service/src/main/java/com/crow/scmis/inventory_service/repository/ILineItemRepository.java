package com.crow.scmis.inventory_service.repository;

import com.crow.scmis.inventory_service.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILineItemRepository extends JpaRepository<LineItem,String> {
}
