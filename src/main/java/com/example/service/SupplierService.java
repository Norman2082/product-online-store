package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.SupplierNotFoundException;
import com.example.persistence.domain.Supplier;
import com.example.persistence.repository.SupplierRepository;
import com.example.rest.dto.SupplierDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@AllArgsConstructor
@Data
public class SupplierService {
	@Autowired
	private SupplierRepository repo;
	@Autowired
	private ModelMapper mapper;
	
	private SupplierDTO mapToDTO(Supplier supplier) {
		return this.mapper.map(supplier, SupplierDTO.class);
	}
	
	public SupplierDTO addSupplier(Supplier supplier){
		Supplier saved = this.repo.save(supplier);
		return this.mapToDTO(saved);
	}
	
	public List<SupplierDTO> getAllSuppliers(){
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public SupplierDTO updateSupplier(Long id, Supplier supplier) {
		Optional<Supplier> tempSupplier = Optional.of(this.repo.findById(id).orElseThrow(SupplierNotFoundException::new));
		
		Supplier existing = tempSupplier.get();
		
		existing.setSupplierName(supplier.getSupplierName());
		existing.setPhoneNumber(supplier.getPhoneNumber());
		existing.setEmail(supplier.getEmail());
		existing.setAddress(supplier.getAddress());
		existing.setId(supplier.getId());
		
		Supplier updated = this.repo.save(existing);
		return this.mapToDTO(updated);
	}
	
	public boolean deleteSupplier(Long id) {
		this.repo.findById(id).orElseThrow(SupplierNotFoundException::new);
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
	public SupplierDTO readById(Long id) {
		Supplier found =  this.repo.findById(id).orElseThrow(SupplierNotFoundException::new);
		return this.mapToDTO(found);
	}
//	
	public List<SupplierDTO> readByName(String name){
   List<Supplier> found = this.repo.supplierByName(name).orElseThrow(SupplierNotFoundException::new);
	return found.stream().map(this::mapToDTO).collect(Collectors.toList());
//	
	}

	}

	


	

	
	

	

	

