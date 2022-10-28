package com.example.exception;

	import javax.persistence.EntityNotFoundException;

	import org.springframework.web.bind.annotation.ResponseStatus;

	import org.springframework.http.HttpStatus;

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product does not exist with that ID")
	public class ProductNotFoundException extends EntityNotFoundException{
		private static final long serialVersionUID = 1L;
		public ProductNotFoundException() {}
		public ProductNotFoundException(String msg) {
			super(msg);
		}

	}

	
	
	

