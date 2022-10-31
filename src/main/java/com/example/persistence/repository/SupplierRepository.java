package com.example.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Supplier;

@Repository
	public interface SupplierRepository  extends JpaRepository<Supplier, Long>{
//		
	@Query("select s from Supplier s where s.supplierName=?1")
	Optional<List<Supplier>> supplierByName(String supplierName);

	}
	
	
	

