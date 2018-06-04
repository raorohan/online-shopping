package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> listCategories = new ArrayList<>();

	static {

		Category category1= new Category();
		Category category2= new Category();
		Category category3= new Category();

		// Adding 1st Category
		category1.setId(1);
		category1.setName("Television");
		category1.setDescription("LED Plasma TV");
		category1.setImageurl("CAT_1.png");

		listCategories.add(category1);

		// Adding 2nd Category
		category2.setId(2);
		category2.setName("Laptop");
		category2.setDescription("Core-I5 RAM 4GB");
		category2.setImageurl("CAT_2.png");

		listCategories.add(category2);
		
		// Adding 2nd Category
				category3.setId(3);
				category3.setName("Mobile");
				category3.setDescription("5Inch RAM 4GB");
				category3.setImageurl("CAT_3.png");

				listCategories.add(category3);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return listCategories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		
		for( Category category : listCategories)
		if(category.getId() == id) return category;
		
		return null;
	}

}
