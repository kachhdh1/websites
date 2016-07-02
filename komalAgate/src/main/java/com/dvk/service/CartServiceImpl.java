package com.dvk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvk.dao.CartDao;
import com.dvk.model.Cart;
import com.dvk.model.CartItem;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	public Cart getCartById(int cartId) {
		return cartDao.getCartById(cartId);
	}

	public void updateCart(Cart cart) {
		cartDao.updateCart(cart);
	}

	public void addCartItem(CartItem item) {
		cartDao.addCartItem(item);
		
	}

	public void removeCartItem(CartItem cartItem) {
		cartDao.removeCartItem(cartItem);
	}

	public void removeAllCartItems(Cart cart) {
		cartDao.removeAllCartItems(cart);
	}

	public CartItem getCartItemByProductId(int productId) {
		return cartDao.getCartItemByProductId(productId);
	}

}
