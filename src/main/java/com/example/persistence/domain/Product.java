package com.example.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	private Long productQuantity;
	private Float productPrice;
	private String productDetails;
	private Long productOrders;
	
	
	private String productName;
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
	
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
	
	

	public Product(Long id, String productName, Long productQuantity, Float productPrice,
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
		return "Product [id=" + id + ", productQuantity=" + productQuantity + ", productPrice=" + productPrice
				+ ", productDetails=" + productDetails + ", productOrders=" + productOrders + ", productName="
				+ productName + ", suppliers=" + suppliers + "]";
	}

	public Product() {
		super();
	}

}


	
	
	
	
	
	

