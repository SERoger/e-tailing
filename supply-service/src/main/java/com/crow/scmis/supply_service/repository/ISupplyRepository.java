package com.crow.scmis.supply_service.repository;

import com.crow.scmis.supply_service.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplyRepository extends JpaRepository<Supply,String> {
}
