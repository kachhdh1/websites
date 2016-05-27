package com.dvk.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String cartId;

	Map<String, CartItem> cartItems = new HashMap<String, CartItem>();

	private int total;

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public int getTotal() {
		return total;
	}

	public Cart(String cartId, Map<String, CartItem> cartItems, int total) {
		super();
		this.cartId = cartId;
		this.cartItems = cartItems;
		this.total = total;
	}

	public Cart() {
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void addCartItem(CartItem item) {
		String productId = item.getProduct().getId();

		if (cartItems.containsKey(productId)) {
			// product exists in the list, so it must be updated
			CartItem existingItem = cartItems.get(productId);
			existingItem.setQuantity(existingItem.getQuantity()
					+ item.getQuantity());
			cartItems.put(productId, existingItem);
		} else {
			cartItems.put(productId, item);
		}
		
		updateCartAmout();
	}
	
	public void removeItem(CartItem item){
		String productId = item.getProduct().getId();

		if (cartItems.containsKey(productId)) {
			cartItems.remove(productId);
		}
		updateCartAmout();
	}

	private void updateCartAmout() {
		total = 0;
		for(CartItem item : cartItems.values()){
			total+=item.getItemAmount();
		}
	}

}
