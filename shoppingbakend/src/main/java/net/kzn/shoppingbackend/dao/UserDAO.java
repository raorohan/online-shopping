package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

public interface UserDAO {

	
	//AddUser
	
		boolean addUser(User user);
	//AddAddress
		
		boolean addAddress(Address address);
		
		//get Billing address for a particular User
		Address getBillingAddress(int userId);
		
		// get List of shipping address for a particular user
		List<Address> listShippingAddress(User user);
	//AddCart
		boolean updateCart(Cart cart);
		
		User userGetByEmail(String email);
		
		User authenticateUser(String email, String pass);
	//UpdateUSer
	//DeleteUser
}
