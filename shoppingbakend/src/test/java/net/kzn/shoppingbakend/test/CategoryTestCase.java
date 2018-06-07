package net.kzn.shoppingbakend.test;

import static org.junit.Assert.assertEquals;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	/*@Test
	public void testAddCategory()
	{
		// Adding 1st Category
		Category category = new Category();
		category.setName("Television");
		category.setDescription("LED Curv TV");
		category.setImageurl("CAT_1.png");
		
		assertEquals("Successfully added a category into the table",true,categoryDAO.add(category));
		
		 category = new Category();
		category.setName("Mobile");
		category.setDescription("Nadroid");
		category.setImageurl("CAT_2.png");
		
		assertEquals("Successfully added a category into the table",true,categoryDAO.add(category));
		
		 category = new Category();
		category.setName("Laptop");
		category.setDescription("Caore- i7");
		category.setImageurl("CAT_3.png");
		
		assertEquals("Successfully added a category into the table",true,categoryDAO.add(category));
		
	}*/
	
	/*@Test
	public void testGetCategory()
	{
		category = categoryDAO.get(2);
		
		assertEquals("Successfully fetched a sinle category based on id","Mobile",category.getName());
		
	}*/
	
	/*@Test
	public void testUpdateCategory()
	{
		category = categoryDAO.get(1);
		category.setName("Television");
		assertEquals("Successfully updated a sinle category based on id",true,categoryDAO.update(category));
		
	}*/
	
	
	/*@Test
	public void testDeleteCategory(){
		
		category = categoryDAO.get(1);
		assertEquals("Successfully deleted a sinle category based on id",true,categoryDAO.delete(category));
			}*/
	
	/*@Test
	public void testListCategory()
	{
		assertEquals("Successfully fetched the list with active as true",2,categoryDAO.list().size());
		
	}*/
	
	@Test
	public void testCrudOperation()
	{
		// Add Category
		
		Category category = new Category();
		category.setName("TV");
		category.setDescription("LED Curv TV");
		category.setImageurl("CAT_1.png");
		
		assertEquals("Successfully added a category into the table",true,categoryDAO.add(category));
		
		 category = new Category();
		category.setName("Mobile");
		category.setDescription("Nadroid");
		category.setImageurl("CAT_2.png");
		
		assertEquals("Successfully added a category into the table",true,categoryDAO.add(category));
		
		 category = new Category();
		category.setName("Laptop");
		category.setDescription("Caore- i7");
		category.setImageurl("CAT_3.png");
		
		assertEquals("Successfully added a category into the table",true,categoryDAO.add(category));
		
		
		category = categoryDAO.get(1);
		category.setName("Television");
		assertEquals("Successfully updated a sinle category based on id",true,categoryDAO.update(category));
		
		// deleting
		assertEquals("Successfully deleted a sinle category based on id",true,categoryDAO.delete(category));
		
		
	}

}
