package com.example.persistence.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Supplier {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	 
	@NotNull
    @Size(min = 0, max = 55)
	private String supplierName;
	
	@Min(0)
    @Max(20)
	private Long phoneNumber;
	
	private String email;
	
	@NotNull
	private String address;

	@ManyToOne
    private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Supplier(Long id, @NotNull @Size(min = 0, max = 55) String supplierName, @Min(0) @Max(20) Long phoneNumber,
			String email, @NotNull String address, Product product) {
		super();
		this.id = id;
		this.supplierName = supplierName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.product = product;


		}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", supplierName=" + supplierName + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", address=" + address + ", product=" + product + "]";
	}




	public Supplier() {
		super();
	}

	}

