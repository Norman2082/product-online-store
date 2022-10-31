package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.persistence.domain.Product;
import com.example.persistence.repository.ProductRepository;
import com.example.rest.dto.ProductDTO;
import com.example.service.ProductService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
	public class ProductServiceUnitTest {
	
	
	@MockBean
	private ProductRepository repo;
	
	@MockBean
	private ModelMapper mapper;

	@InjectMocks
	private ProductService service;
	
	private Product productI;
	private Product productO;
	private ProductDTO productDTO;
	
	@BeforeEach
	void setProduct() {
		this.productI=new Product();
		this.productI.setProductName("Test Product");
		this.productI.setProductQuantity(345l);
		this.productO=this.productI;
		this.productO.setProductId(1L);
		this.productDTO= new ProductDTO();
		this.productDTO.setProductId(1L);
		this.productDTO.setProductName("Test Product");
		this.productDTO.setProductQuantity(345l);
	}
	
	@Test
	void testCreate() {
		when(this.repo.save(this.productI)).thenReturn(this.productO);
		when(this.mapper.map(this.productO, ProductDTO.class)).thenReturn(this.productDTO);
		assertEquals(this.productDTO,service.addProduct(this.productI));
	}
	
	@Test 
	void testGetAll() {
		ArrayList<Product> temp1 = new ArrayList<>();
		temp1.add(productO);
		ArrayList<ProductDTO> temp2 = new ArrayList<>();
		temp2.add(productDTO);
		when(this.repo.findAll()).thenReturn(temp1);
		when(this.mapper.map(this.productO, ProductDTO.class)).thenReturn(this.productDTO);
		assertEquals(temp2,service.getAllProducts());
	}
	
	@Test 
	void testGetOne() {
		Long id = 1L;
	Optional<Product> temp = Optional.of(this.productO);
   	when(this.repo.findById(id)).thenReturn(temp);
		when(this.mapper.map(this.productO, ProductDTO.class)).thenReturn(this.productDTO);		
		assertEquals(this.productDTO,service.getProductById(id));
	}
	
	@Test 
	void testUpdate() {
		Long id = 1L;
		Optional<Product> temp = Optional.of(this.productO);
		when(this.repo.findById(id)).thenReturn(temp);
		when(this.repo.save(this.productI)).thenReturn(this.productO);
		when(this.mapper.map(this.productO, ProductDTO.class)).thenReturn(this.productDTO);
		assertEquals(this.productDTO,service.updateProduct(id,productI));
	}
	
    @Test 
   	void testDelete() {
		Long id = 1L;
	when(this.repo.existsById(id)).thenReturn(false);
		assertEquals(true,service.deleteProduct(id));
	}
}


	
	
	
	
	
	
	
	


