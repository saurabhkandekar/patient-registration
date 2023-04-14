package com.crossasyst.personregistration.repository;


import com.crossasyst.personregistration.entity.PracticeContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeContactRepository extends JpaRepository<PracticeContactEntity,Long> {
}
