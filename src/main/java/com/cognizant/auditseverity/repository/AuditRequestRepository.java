package com.cognizant.auditseverity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.auditseverity.entity.AuditRequestData;

public interface AuditRequestRepository extends JpaRepository<AuditRequestData, Long>{

}
