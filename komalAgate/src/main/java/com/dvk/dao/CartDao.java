package com.dvk.dao;

import com.dvk.model.Cart;
import com.dvk.model.CartItem;


public interface CartDao {

	Cart getCartById(int cartId);
	
	void updateCart(Cart cart);

	void addCartItem(CartItem item);

	void removeCartItem(CartItem cartItem);

	void removeAllCartItems(Cart cart);

	CartItem getCartItemByProductId(int productId);

}
