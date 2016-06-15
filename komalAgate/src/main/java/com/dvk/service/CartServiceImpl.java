package com.dvk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dvk.model.Cart;
import com.dvk.model.CartItem;
import com.dvk.model.Product;

@Service
public class CartServiceImpl implements CartService {

	public Cart getCartById(String cartId) {
		Product product = new Product();
		product.setProductName("Product One");
		product.setProductPrice("10 rupees");
		CartItem item = new CartItem(product, 2);
		Map<String, CartItem> cartItems = new HashMap<String, CartItem>();
		cartItems.put("Product1",item);
		return new Cart(cartId,cartItems,800);
	}

}
