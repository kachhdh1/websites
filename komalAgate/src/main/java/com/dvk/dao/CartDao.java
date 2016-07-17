package com.dvk.dao;

import com.dvk.exceptions.CartInvalidException;
import com.dvk.model.Cart;
import com.dvk.model.CartItem;


public interface CartDao {

	Cart getCartById(int cartId);
	
	void updateCart(Cart cart);

	void addCartItem(CartItem item);

	void removeCartItem(CartItem cartItem);

	void removeAllCartItems(Cart cart);

	CartItem getCartItemByProductId(int productId);
	
	//if this method was not included in the interface, then 
	//spring wont be able to recognize the validate method 
	// in the daoImpl
	Cart validate(int cartId) throws CartInvalidException;  

}
