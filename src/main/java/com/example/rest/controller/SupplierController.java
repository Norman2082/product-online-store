package com.example.rest.controller;


import java.util.List;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.Supplier;
import com.example.rest.dto.SupplierDTO;
import com.example.service.SupplierService;

import lombok.AllArgsConstructor;

@RestController
	@AllArgsConstructor
	public class SupplierController {
		@Autowired
		private SupplierService service;
		
		@PostMapping("addSupplier")
		public SupplierDTO addSupplier(@RequestBody Supplier supplier) {
			return service.addSupplier(supplier);
		}
		
		@GetMapping("/allSuppliers")
		public List<SupplierDTO> getAllSuppliers(){
			return service.getAllSuppliers();
		}
		
		@PutMapping("/updateSupplier/{id}")
		public SupplierDTO updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
			return service.updateSupplier(id, supplier);
		}
		
		@DeleteMapping("/deleteSupplier/{id}")
		public boolean deleteSuppplier(@PathVariable Long id) {
			return service.deleteSupplier(id);
		}
		
		@GetMapping("/supplierById")
		public SupplierDTO readSupplierById(@PathParam("supplierId") Long id) {
			return service.readById(id);
		
		
//		@GetMapping("/supplierByName")
	//	public List<SupplierDTO> readByName(@PathParam("supplierName") String supplier){
	//	return service.supplierByName(supplier);
//		}

	
		}}
	
	
	
	
	
	

