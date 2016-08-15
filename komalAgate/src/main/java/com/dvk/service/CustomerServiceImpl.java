package com.dvk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dvk.dao.CustomerDao;
import com.dvk.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @Autowired
    @Qualifier("dvkAuthenticationManager")
    private AuthenticationManager authenticationManager;

    public void addCustomer (Customer customer) {
    	//added logic for encoding password
    	String plainPassword = customer.getPassword();
    	String encodedPass = encoder.encode(customer.getPassword());
    	customer.setPassword(encodedPass);
        customerDao.addCustomer(customer);
        
        //after storing the result in DB, store the credentials
        //in spring security context
        Authentication credentials = 
        		new UsernamePasswordAuthenticationToken(customer.getUsername(), plainPassword);
        credentials = authenticationManager.authenticate(credentials);
        if(credentials.isAuthenticated()){
        	//store the credentials in the spring securitycontext
        	SecurityContextHolder.getContext().setAuthentication(credentials);
        }else{
        	System.out.println("Sorry : user cannot be added");
        }
        	
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
