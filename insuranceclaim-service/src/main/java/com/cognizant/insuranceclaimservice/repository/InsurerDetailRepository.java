package com.cognizant.insuranceclaimservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.insuranceclaimservice.model.InsurerDetail;

public interface InsurerDetailRepository  extends JpaRepository<InsurerDetail, Long>{
InsurerDetail findByInsurerPackageName(String insurerPackageName);
}
