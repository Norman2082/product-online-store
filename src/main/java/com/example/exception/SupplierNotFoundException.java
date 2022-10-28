package com.example.exception;
	
	import javax.persistence.EntityNotFoundException;

	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Supplier does not exist with that ID")
	public class SupplierNotFoundException extends EntityNotFoundException{
		private static final long serialVersionUID = 1L;
		public SupplierNotFoundException() {}
		public SupplierNotFoundException(String msg) {
			super(msg);
		}

	}

	
	
	

