package com.dvk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvk.service.CustomerOrderService;

@Controller
@RequestMapping("/customer/order")
public class CustomerOrderController {

	@Autowired
	CustomerOrderService customerOrderService;
	
	@RequestMapping("/{cartId}")
	public String createOrder(@PathVariable("cartId") int cartId){
		
		customerOrderService.createOrder(cartId);
		// return redirect to spring web-flow Work-flow
		return "redirect:/checkout?cartId="+cartId;
	}
	
}
