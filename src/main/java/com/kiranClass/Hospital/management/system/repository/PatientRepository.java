package com.kiranClass.Hospital.management.system.repository;

import java.beans.JavaBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiranClass.Hospital.management.system.entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	

}
