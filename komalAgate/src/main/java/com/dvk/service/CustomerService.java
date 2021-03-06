package com.dvk.service;

import java.util.List;

import com.dvk.model.Customer;

public interface CustomerService {
	
	void addCustomer (Customer customer);

    Customer getCustomerById (int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);

}
