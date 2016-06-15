package com.dvk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvk.model.Cart;
import com.dvk.service.CartService;


@Controller
@RequestMapping(value="/rest/cart")
public class CartController {
	
	@Autowired
	CartService cartService;

	@RequestMapping(value="/{cartId}",method=RequestMethod.GET)
	public @ResponseBody Cart getCart(@PathVariable(value="cartId") String cartId){
		return cartService.getCartById(cartId);
	}
}
