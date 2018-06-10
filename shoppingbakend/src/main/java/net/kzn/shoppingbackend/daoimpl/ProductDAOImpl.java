package net.kzn.shoppingbackend.daoimpl;

import java.util.List;
import java.util.ArrayList;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	List<Product> productlist = new ArrayList<Product>();
	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub

		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub

		try {
			return sessionFactory
					.getCurrentSession()
					.get(Product.class,Integer.valueOf(id));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try {

			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {

			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		try {

			product.setActive(false);
			return this.update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Product> listActiveProducts() {
		
		
		 String selectActiveProduct = "FROM Product WHERE active = :active";
		 try{
			  return sessionFactory.getCurrentSession()
				 .createQuery(selectActiveProduct, Product.class)
				 .setParameter("active", true)
				 .getResultList();
		 }catch(Exception e){e.printStackTrace(); System.out.println("problem is hwre");}
		 return null;
		
		/*Product product = new Product();
		product.setName("OPPO 5");
		product.setBrand("OPPO");
		product.setDescription("OPPO Phone Description");
		product.setActive(true);
		product.setUnitPrice(12000);
		product.setQuantity(10);
		product.setCategoryId(3);
		product.setSupplierId(3);
		productlist.add(product);
		return productlist;*/
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		
		String selectActiveProductByCategory = "FROM Product WHERE active=:active AND categoryId= :categoryId";
		 Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProductByCategory, Product.class);
		 query.setParameter("active", true);
		 query.setParameter("categoryId", categoryId);
		 return query.getResultList();
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active:active ORDER BY id", Product.class);
		 
		 
		 return query.setParameter("active", true)
				 .setFirstResult(0).setMaxResults(count).getResultList();
	}

}
