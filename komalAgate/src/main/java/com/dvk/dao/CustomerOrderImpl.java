package com.dvk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dvk.model.CustomerOder;

@Repository
@Transactional
public class CustomerOrderImpl implements CustomerOrderDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void createOrder(CustomerOder customerOrder) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customerOrder);
		session.flush();

	}

}
