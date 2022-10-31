package com.example.rest.dto;

import com.example.persistence.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;

import com.example.persistence.domain.Supplier;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data

public class ProductDTO {

	private Long id;

	private String productName;

	private Long productQuantity;

	private Float productPrice;

	private String productDetails;

	private Long productOrders;
	
	
	private List<Supplier> suppliers = new ArrayList<>();


	public Long getId() {
		return id;
	}

	public void setProductId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public Long getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(Long productOrders) {
		this.productOrders = productOrders;
	}


	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	
	
	
	public ProductDTO(Long id, String productName, Long productQuantity, Float productPrice,
			String productDetails, Long productOrders) {
		super();
		this.id = id;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productDetails = productDetails;
		this.productOrders = productOrders;
		
	
		
	}
	
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", productName=" + productName + ", productQuantity=" + productQuantity
				+ ", productPrice=" + productPrice + ", productDetails=" + productDetails + ", productOrders="
				+ productOrders + ", suppliers=" + suppliers + "]";
	}

	public ProductDTO() {
		super();
	}

	

}
