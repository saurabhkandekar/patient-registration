package com.crossasyst.personregistration.repository;

import com.crossasyst.personregistration.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity,Long> {
}
