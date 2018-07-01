package net.kzn.shoppingbakend.test;

import static org.junit.Assert.assertEquals;
import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user=null;
	private Address address = null;
	private Cart cart;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testGetAddresses()
	{
		user = userDAO.userGetByEmail("kn@gmail.com");
		
		//assertEquals("Failed, let me know",4,user.getId());
	
		assertEquals("Failed, let me know","Ahmedabad",userDAO.getBillingAddress(user.getId()).getCity());
		
	}
	
	
	/*@Test
	public void testAddAddress(){
		
		user = userDAO.userGetByEmail("shivam.dubey11oct@gmail.com");
		address = new Address();
		address.setAddressLineOne("I 1203 Sangria");
		address.setAddressLineTwo("Hinjewadi Phase 3");
		address.setCity("pune");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("411057");
		address.setShipping(true);
		
		address.setUser(user);
		
		assertEquals("Failed, let me know",true,userDAO.addAddress(address));
		
	}*/
	
	
	/*@Test
	public void testAddAddress()
	{
		// we need to add an user
		user = new User();
		user.setFirstName("Shivam");
		user.setLastName("Dubey");
		user.setEmail("shivam.dubey11oct@gmail.com");
		user.setContactNumber("9028000517");
		user.setRole("USER");
		user.setPassword("ritu");
		assertEquals("Tell me if something goes wrong", true, userDAO.addUser(user));
		
		
		//we need to add address
		address = new Address();
		address.setAddressLineOne("I 1201 Sangria");
		address.setAddressLineTwo("Hinjewadi Phase 3");
		address.setCity("pune");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("411057");
		address.setBilling(true);
		// attach user to adress
		address.setUser(user);
		
		assertEquals("Failed, let me know",true,userDAO.addAddress(address));
		
		// adding shipping address
		address = new Address();
		address.setAddressLineOne("I 1202 Sangria");
		address.setAddressLineTwo("Hinjewadi Phase 3");
		address.setCity("pune");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("411057");
		address.setShipping(true);
		// attach user to adress
		address.setUser(user);
		
		assertEquals("Failed at shipping , let me know",true,userDAO.addAddress(address));
		
		
		
		
	}*/
	/*@Test
	public void testUpdateCart()
	{
		user = userDAO.userGetByEmail("shivam.dubey11oct@gmail.com");
		cart = user.getCart();
		
		cart.setCartLines(2);
		cart.setGrandTotal(100);
		
		assertEquals("Failed , let me know",true, userDAO.updateCart(cart));
		
		
	}*/
	
	/*@Test
	public void testAdd()
	{
		user = new User();
		user.setFirstName("Shivam");
		user.setLastName("Dubey");
		user.setEmail("shivam.dubey11oct@gmail.com");
		user.setContactNumber("9028000517");
		user.setRole("USER");
		user.setPassword("ritu");
		
		if(user.getRole().equals("USER"))
		{
			//create cart for user
			cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
			// now checing cart addition
			assertEquals("Failed, let me know", true,userDAO.addCart(cart));
			
			//also adding shipping address for user
		}
		
		assertEquals("Tell me if something goes wrong", true, userDAO.addUser(user));
		
		
		// For adding address , we need a particular user id
		
		address = new Address();
		address.setAddressLineOne("I 1201 Sangria");
		address.setAddressLineTwo("Hinjewadi Phase 3");
		address.setCity("pune");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("411057");
		address.setBilling(true);
		
		// here linking user with address
		address.setUserId(user.getId());
		// now checking adding address
		
		assertEquals("Failed, let me know",true,userDAO.addAddress(address));
		
		
		
		
		
		// add shipping addressaddress = new Address();
		address.setAddressLineOne("I 1202 Sangria");
		address.setAddressLineTwo("Hinjewadi Phase 3");
		address.setCity("pune");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("411057");
		address.setShipping(true);
		
		// here linking user with address
		address.setUserId(user.getId());
		// now checking adding address
		assertEquals("Failed, let me know", true,userDAO.addAddress(address));
		
		
		
	}
*/
}
