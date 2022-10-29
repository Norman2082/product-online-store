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

import com.example.persistence.domain.Product;
import com.example.rest.dto.ProductDTO;
import com.example.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public ProductDTO addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@GetMapping("/allProducts")
	public List<ProductDTO> getAllProducts(){
		return service.getAllProducts();
	}
	
	
	@PutMapping("/updateProduct/{id}")
	public ProductDTO updateBand(@PathVariable Long id, @RequestBody Product product) {
		return service.updateProduct(id, product);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public boolean deleteProduct(@PathVariable Long id) {
		return service.deleteProduct(id);
	}
	
	@GetMapping("/productById/{id}")
	public ProductDTO readProductById(@PathParam("product") Long id) {
		return service.readById(id);
	}
	
	@GetMapping("/productByName")
	public ProductDTO readByName(@PathParam("product") String product){
	return service.productByName(product);
//	}

}}
	
	
	
	
	
	
	

