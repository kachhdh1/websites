package com.dvk.service;

import com.dvk.dao.CustomerDao;
import com.dvk.model.Customer;
import com.dvk.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void addCustomer (Customer customer) {
    	//added logic for encoding password
    	String encodedPass = encoder.encode(customer.getPassword());
    	customer.setPassword(encodedPass);
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username) {
        return customerDao.getCustomerByUsername(username);
    }
}
