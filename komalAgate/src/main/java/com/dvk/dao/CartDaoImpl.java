package com.dvk.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dvk.exceptions.CartInvalidException;
import com.dvk.model.Cart;
import com.dvk.model.CartItem;
import com.dvk.service.CartServiceImpl;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	public Cart getCartById(int cartId) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = (Cart) session.get(Cart.class, cartId);
		return cart;
	}

	public void updateCart(Cart cart) {
		double grandTotal = cartServiceImpl.getGrandTotalForCart(cart);
		cart.setGrandTotal(grandTotal);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		session.flush();
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
	
	/**
	 * This function is called by spring-web-flow to valid 
	 * if the cart is valid or not. And then updates the total amount
	 * @param cartId
	 * @return
	 * @throws CartInvalidException
	 */
	public Cart validate(int cartId)  throws CartInvalidException{
		
        Cart cart=getCartById(cartId);
        if(cart==null||cart.getCartItems().size()==0) {
            throw new CartInvalidException();
        }
        updateCart(cart);
        return cart;
    }

}
