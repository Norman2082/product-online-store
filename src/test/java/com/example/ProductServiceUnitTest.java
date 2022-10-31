package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.BDDMockito.given;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.persistence.domain.Product;
import com.example.persistence.repository.ProductRepository;
import com.example.rest.dto.ProductDTO;
import com.example.service.ProductService;

@SpringBootTest

	public class ProductServiceUnitTest {
		//This file tests the service layer for Product
		@MockBean
		private ProductRepository repo;
		@Autowired
		private ProductService productService;
		
	
		//Test the read by id functionality
		@Test
		void testProductById()
		{
			final Long id = 1L;
			final Product product = new Product();
			given(repo.findById(id)).willReturn(Optional.of(product));
			final ProductDTO dto = productService.readById(id);
			assertThat(dto).isNotNull();
		}
		


	//Test to see if it correctly retrieves the Product data
	@Test
		void testProductByName()
	{
			List<Product> productList = new ArrayList<>();
			productList.add(new Product(1L,"bolts",889, 100,"Cranks", 100));
	    given(repo.findAll()).willReturn(productList);{
	List<ProductDTO> dto = productService.getAllProducts();
	assertThat(dto).usingRecursiveComparison().isEqualTo(productList);}
	}	


		//Test for create
	@Test
void testAddProduct() 	{
	final Product product = new Product(1L,"coolent", 673, 33.50,"LUK",40);
		given(this.repo.save(product)).willReturn(product);
		ProductDTO dto = this.productService.addProduct(product);			
		assertThat(dto).usingRecursiveComparison().isEqualTo(product);
	}
		
		//Test for delete
		@Test
		void testDeleteProduct()
		{
			final Long id = 1L;
			productService.deleteProduct(id);
			productService.deleteProduct(id);
			verify(repo, times(1)).deleteById(id);
		}
	//Test for updating product
	    @Test
	void testUpdateProduct()
	{			final Product TEST_SAVED_PRODUCT = new Product (1L, "brakes", 80, 500,"Tensil", 89);
			given(repo.save(any(Product.class))).willReturn(TEST_SAVED_PRODUCT);
			Product product = repo.save(TEST_SAVED_PRODUCT);
		assertThat(product).isNotNull();
		}
	}

