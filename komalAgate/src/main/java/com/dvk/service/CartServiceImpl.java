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
		//also set the grand total for the cart
		Cart cart = cartDao.getCartById(cartId);
		cart.setGrandTotal(getGrandTotalForCart(cart));
		return cart;
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
	
	private double getGrandTotalForCart(Cart cart){
		double total = 0;
		for(CartItem items : cart.getCartItems()){
			total+=items.getTotalAmount();
		}
		return total;
	}

}
