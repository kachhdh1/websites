package com.dvk.service;

import com.dvk.model.Cart;
import com.dvk.model.CartItem;

public interface CartService {
	
	public Cart getCartById(int cartId);
	
	void updateCart(Cart cart);

	public void addCartItem(CartItem item);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);

	public CartItem getCartItemByProductId(int productId);

}
