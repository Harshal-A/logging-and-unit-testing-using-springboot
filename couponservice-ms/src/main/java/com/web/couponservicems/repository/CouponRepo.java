package com.web.couponservicems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.couponservicems.model.Coupon;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

	
}
