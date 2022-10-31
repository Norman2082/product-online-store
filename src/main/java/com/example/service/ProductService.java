package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.exception.ProductNotFoundException;
import com.example.persistence.domain.Product;
import com.example.persistence.repository.ProductRepository;
import com.example.rest.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
	@AllArgsConstructor
	@Data
	public class ProductService {
@Autowired
		private ProductRepository repo;
@Autowired
		private ModelMapper mapper;
		
		private ProductDTO mapToDTO(Product product) {
			return this.mapper.map(product, ProductDTO.class);
		}
		
		public ProductDTO addProduct(Product product) {
			Product saved = this.repo.save(product);
			return this.mapToDTO(saved);
		}
		
		public List<ProductDTO> getAllProducts() {
			return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
		}
		
		public ProductDTO updateProduct(Long id, Product product) {
			Optional<Product> tempProduct = Optional.of(this.repo.findById(id).orElseThrow(ProductNotFoundException::new));
			
			Product existing = tempProduct.get();
			existing.setProductId(product.getId());
			existing.setProductName(product.getProductName());
			existing.setSuppliers(product.getSuppliers());
			existing.setProductDetails(product.getProductDetails());
			existing.setProductOrders(product.getProductOrders());
			existing.setProductPrice(product.getProductPrice());
		    existing.setProductQuantity(product.getProductQuantity());
		    
			

			Product updated = this.repo.save(existing);
			return this.mapToDTO(updated);
		}
		
		public boolean deleteProduct(Long id) {
			this.repo.findById(id);
			this.repo.deleteById(id);
			boolean exists = this.repo.existsById(id);
			return !exists;
		}
		
		public ProductDTO readById(Long id) {
	        Product found = this.repo.findById(id).orElseThrow(ProductNotFoundException::new);
	        return this.mapToDTO(found);}

		

		public Object productById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}


	    
		
	public ProductDTO productByName(String productName) {
			Product found = this.repo.productByName(productName).orElseThrow(ProductNotFoundException::new);
			return this.mapToDTO(found);
	}
	
			public ProductDTO getProductById(Long id) {
				return this.mapToDTO(this.repo.findById(id).get());
				
		}

	}		
	
	        
	

	
	
	
	
	
	
	
	
	

