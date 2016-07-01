package com.dvk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dvk.model.Customer;
import com.dvk.service.CustomerService;

/**
 * The class will handle all the cart related activities The url mapping is
 * /customer/** which will ensure that the customer is logged in and existing as
 * the url is defined in application spring context file
 * 
 * @author Dharmik
 *
 */
@Controller
@RequestMapping(value = "/customer/cart")
public class CartController {

	@Autowired
	CustomerService customerService;

	/**
	 * Params - AuthentiationPrincipal annotation added in spring 3.2 to get
	 * logged in user details. User type is from spring security package only.
	 * Additional configuration is added in mvc annotation driven argument in
	 * xml files.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getCart(@AuthenticationPrincipal User loggedInUser) {
		Customer customer = customerService.getCustomerByUsername(loggedInUser
				.getUsername());
		int cartId = customer.getCart().getCartId();

		return "redirect:/customer/cart/"+cartId;
	}
	
	/**
	 * the function will catch the redirected url and hold the value 
	 * of cartId. This then add the cartId in the model and hence the page.
	 * cartId will be used by angular js and rest services will be 
	 * called to retrive the cart information. 
	 * @return
	 */
	@RequestMapping("/{cartId}")
	public String getCartRedirect(@PathVariable(value="cartId") int cartId,
			Model model){
		model.addAttribute("cartId",cartId);
		return "cart";
	}

}
