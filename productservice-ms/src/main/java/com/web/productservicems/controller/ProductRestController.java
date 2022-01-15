package com.web.productservicems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.web.productservicems.dto.Coupon;
import com.web.productservicems.model.Product;
import com.web.productservicems.repository.ProductRepo;

@RestController
@RequestMapping("productapi")
public class ProductRestController {

	@Autowired
	private ProductRepo repo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponservice.url}")
	private String couponServiceUrl;

	public String getCouponServiceUrl() {
		return couponServiceUrl;
	}

	public void setCouponServiceUrl(String couponServiceUrl) {
		this.couponServiceUrl = couponServiceUrl;
	}

	@PostMapping("/products")
	public Product create(@RequestBody Product product) {
		Coupon coupon = restTemplate.getForObject(getCouponServiceUrl() + product.getCouponCode(),
				Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);
	}

}
