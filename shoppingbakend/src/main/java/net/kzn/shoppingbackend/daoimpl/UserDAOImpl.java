package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	
	// FirstComeFirst autowire sessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
		
		
	}

	@Override
	public boolean addAddress(Address address) {
		try {			
			
			sessionFactory.getCurrentSession().persist(address);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
				
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}catch(Exception e)
		{
			return false;
	}

}

	@Override
	public User userGetByEmail(String email) {
		// TODO Auto-generated method stub
		
		try{
			return sessionFactory.getCurrentSession().createQuery("FROM User WHERE email=: email", User.class).setParameter("email", email).getSingleResult();
		}catch(Exception ex){
			return null;
		}
				
		}
	
	
	@Override
	public User authenticateUser(String email, String pass) {
		// TODO Auto-generated method stub
		
		try{
			return sessionFactory.getCurrentSession().createQuery("FROM User WHERE email=: email AND password =: password", User.class).setParameter("email", email).setParameter("password", pass).getSingleResult();
		}catch(Exception ex){
			return null;
		}
				
		}

	@Override
	public Address getBillingAddress(int userId) {
		// TODO Auto-generated method stub
		
		try{
			return sessionFactory.getCurrentSession().createQuery("FROM Address WHERE userId =: userId AND billing =: billing", Address.class).setParameter("userId", userId).setParameter("billing", true).getSingleResult();
		}catch(Exception ex){
			return null;
		}
		
	}

	@Override
	public List<Address> listShippingAddress(User user) {
		// TODO Auto-generated method stub
		try{
			return sessionFactory.getCurrentSession().createQuery("FROM Address WHERE user =: user AND shipping =: shipping", Address.class).setParameter("user", user).setParameter("shipping", true).getResultList();
		}catch(Exception ex){
			return null;
		}
	}
}
