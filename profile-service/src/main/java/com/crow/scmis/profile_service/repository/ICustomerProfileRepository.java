package com.crow.scmis.profile_service.repository;

import com.crow.scmis.profile_service.entity.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerProfileRepository extends JpaRepository<CustomerProfile,String> {
}
