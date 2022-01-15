package com.web.couponservicems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.web.couponservicems.controller.CouponRestController;
import com.web.couponservicems.model.Coupon;
import com.web.couponservicems.repository.CouponRepo;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CouponserviceMsApplicationTests {

	private static final String SUPERSALE = "SUPERSALE";

	@Mock
	CouponRepo repo;
	
	@InjectMocks
	CouponRestController controller;
	
	@Test
	public void create_shouldCreateCoupon() {
		Coupon coupon=new Coupon();
		coupon.setcode(SUPERSALE);
		when(repo.save(coupon)).thenReturn(coupon);
		Coupon newCoupon= controller.createCoupon(coupon);
		verify(repo).save(coupon);
		assertNotNull(newCoupon);
		assertEquals(SUPERSALE, newCoupon.getcode());
	}
	
	@Test
	public void getCoupon_shouldGetCoupon() {
		Coupon coupon=new Coupon();
		coupon.setcode(SUPERSALE);
		coupon.setId(123L);
		coupon.setDiscount(new BigDecimal(100));
		when(repo.findByCode(SUPERSALE)).thenReturn(coupon);
		Coupon newCoupon= controller.getCoupon(SUPERSALE);
		verify(repo).findByCode(SUPERSALE);
		assertNotNull(newCoupon);
		assertEquals(new BigDecimal(100), newCoupon.getDiscount());
	}
	
	
	@Test
	public void createCoupon_whenCouponIsNull() {
		assertThrows(IllegalArgumentException.class, ()->{
			controller.createCoupon(null);
		});
	}
	
	

}
