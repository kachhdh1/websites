package com.dvk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvk.dao.CartDao;
import com.dvk.dao.CustomerOrderDao;
import com.dvk.model.Cart;
import com.dvk.model.Customer;
import com.dvk.model.CustomerOder;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	CustomerOrderDao customerOrderDao;
	
	@Autowired
	CartDao cartDao;
	
	public void createOrder(int cartId) {
	
		CustomerOder customerOrder = new CustomerOder();
		Cart cart = cartDao.getCartById(cartId);
		Customer customer = cart.getCustomer();
		
		customerOrder.setCart(cart);
		customerOrder.setCustomer(customer);
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrderDao.createOrder(customerOrder);
	}

}
