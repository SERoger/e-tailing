package com.crow.scmis.supply_service.repository;

import com.crow.scmis.supply_service.entity.SupplyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplyDetailRepository extends JpaRepository<SupplyDetail,String> {
}
