package com.web.productservicems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.web.productservicems.controller.ProductRestController;
import com.web.productservicems.dto.Coupon;
import com.web.productservicems.model.Product;
import com.web.productservicems.repository.ProductRepo;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductserviceMsApplicationTests {
	private static final String COUPON_SERVICE_URL = "http://localhost:8080/couponapi/coupons/";
	private static final String COUPONCODE="SUPERSALE";

	@Mock
	private ProductRepo repo;
	
	@Mock
	RestTemplate template;
	
	@InjectMocks
	private ProductRestController controller;
	

	@Test
	public void test_createProduct() {
		Product product=new Product();
		product.setCouponCode(COUPONCODE);
		product.setPrice(new BigDecimal(100));
		Coupon coupon=new Coupon();
		coupon.setcode(COUPONCODE);
		coupon.setDiscount(new BigDecimal(10));
		controller.setCouponServiceUrl(COUPON_SERVICE_URL);
		when(template.getForObject(COUPON_SERVICE_URL+COUPONCODE,
				Coupon.class)).thenReturn(coupon);
		
		when(repo.save(product)).thenReturn(product);
		Product newProduct= controller.create(product);
		verify(template).getForObject(COUPON_SERVICE_URL+COUPONCODE,
				Coupon.class);
		verify(repo).save(product);
		assertNotNull(newProduct);
		assertEquals(new BigDecimal(90), newProduct.getPrice());
	}

}
