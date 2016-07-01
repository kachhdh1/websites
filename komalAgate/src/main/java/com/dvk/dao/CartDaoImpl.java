package com.dvk.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dvk.model.Cart;
import com.dvk.model.CartItem;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Cart getCartById(int cartId) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = (Cart) session.get(Cart.class, cartId);
		return cart;
	}

	public void updateCart(Cart cart) {
		//to do later
	}

	public void addCartItem(CartItem item) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(item);
		session.flush();
	}

	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}

	public void removeAllCartItems(Cart cart) {
		
		List<CartItem> cartItems = cart.getCartItems();
		for(CartItem item : cartItems){
			removeCartItem(item);
		}
	}

	public CartItem getCartItemByProductId(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem where productId=?");
		query.setInteger(0, productId);
		session.flush();
		return (CartItem) query.uniqueResult();
	}

}
