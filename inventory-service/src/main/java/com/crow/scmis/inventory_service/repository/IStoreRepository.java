package com.crow.scmis.inventory_service.repository;

import com.crow.scmis.inventory_service.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoreRepository extends JpaRepository<Store,String> {
}
