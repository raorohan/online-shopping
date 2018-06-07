package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
// since every method needs this annotation @Transactional, it's better to put
// at the top
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	/* private static List<Category> listCategories = new ArrayList<>(); */
	@Autowired
	SessionFactory sessionFactory;

	/*
	 * static {
	 * 
	 * Category category1= new Category(); Category category2= new Category();
	 * Category category3= new Category();
	 * 
	 * // Adding 1st Category category1.setId(1);
	 * category1.setName("Television");
	 * category1.setDescription("LED Plasma TV");
	 * category1.setImageurl("CAT_1.png");
	 * 
	 * listCategories.add(category1);
	 * 
	 * // Adding 2nd Category category2.setId(2); category2.setName("Laptop");
	 * category2.setDescription("Core-I5 RAM 4GB");
	 * category2.setImageurl("CAT_2.png");
	 * 
	 * listCategories.add(category2);
	 * 
	 * // Adding 2nd Category category3.setId(3); category3.setName("Mobile");
	 * category3.setDescription("5Inch RAM 4GB");
	 * category3.setImageurl("CAT_3.png");
	 * 
	 * listCategories.add(category3); }
	 */

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		
		String selectactivecategory = "FROM Category WHERE active= :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectactivecategory);
		
		query.setParameter("active", true);
		return query.getResultList();
	}

	/** This method is for getting single category for an ID */
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class,
				Integer.valueOf(id));

	}

	@Override
	public boolean add(Category category) {
		// TODO Auto-generated method stub

		// adding category to seesion object
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// Method which updates single category
	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
