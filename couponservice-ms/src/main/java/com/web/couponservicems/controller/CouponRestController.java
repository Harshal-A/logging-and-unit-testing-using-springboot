package com.web.couponservicems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.couponservicems.model.Coupon;
import com.web.couponservicems.repository.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	private CouponRepo repo;
	
	@PostMapping("/coupons")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		if(coupon==null) {
			throw new IllegalArgumentException("Coupon entity required!!");
		}
		return repo.save(coupon); 
	}
	
	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);
	}
}
