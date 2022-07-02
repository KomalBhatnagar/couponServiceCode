package com.komal.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komal.coupon.model.Coupon;
import com.komal.coupon.repository.CouponRepository;

@RestController
@RequestMapping("/couponapi")
public class CouponController {

	@Autowired
	CouponRepository repo;
	
	@PostMapping("/create")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return repo.save(coupon);
	}
	
	@GetMapping("/getCoupons/{code}")
	public Coupon getCoupons(@PathVariable("code") String code) {
		return repo.findByCode(code);
		
	}
}
