package net.kzn.shoppingbakend.test;

import static org.junit.Assert.assertEquals;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDProducts()
	{
		product = new Product();
		product.setName("OPPO 5");
		product.setBrand("OPPO");
		product.setDescription("OPPO Phone Description");
		product.setActive(true);
		product.setUnitPrice(12000);
		product.setQuantity(11);
		product.setCategoryId(3);
		product.setSupplierId(3);
		//assertEquals("Successfully added a category into the table",true,productDAO.add(product));
		
		//assertEquals("Tell Me if something goes wrong",10,productDAO.listActiveProducts().size());
		assertEquals("Tell Me if something goes wrong",2,productDAO.listActiveProductsByCategory(1).size());
		
		
	
	}

}
