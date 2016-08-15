package com.dvk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dvk.model.BillingAddress;
import com.dvk.model.Customer;
import com.dvk.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerCustomerHome(Model model){
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		customer.setBillingAddress(billingAddress);
		
		model.addAttribute("customer",customer);
		return "registerCustomer";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerCustomer(@Valid @ModelAttribute("customer") Customer customer,
								   BindingResult result, Model model){
		if(result.hasErrors()){
			return "registerCustomer";
		}
		String status = customerService.addCustomer(customer);
		if("success".equals(status)){
			return "registerCustomerSuccess";
		}
		else{
			model.addAttribute("registerErrorMsg", status);
			return "registerCustomer";
		}
	}
}
