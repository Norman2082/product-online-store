package com.example.rest.dto;


//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class SupplierDTO {

	private Long id;

	private String supplierName;

	private Long phoneNumber;

	private String email;

	

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

	public Long getphoneNumber() {
		return phoneNumber;
	}

	public void setphoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public SupplierDTO(Long id, String supplierName, Long phoneNumber, String email) {
		super();
		this.id = id;
		this.supplierName = supplierName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		
	
	
	
	
	}



	@Override
	public String toString() {
		return "SupplierDTO [id=" + id + ", supplierName=" + supplierName + ", phoneNumber=" + phoneNumber + ", email="
				+ email + "]";
	}

	public SupplierDTO() {
		super();
	}

}
