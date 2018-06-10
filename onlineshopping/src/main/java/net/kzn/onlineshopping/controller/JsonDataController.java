package net.kzn.onlineshopping.controller;

import java.util.List;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@ResponseBody
	@RequestMapping(value="/all/products")
	public List<Product> getAllProducts()
	{
		return productDAO.listActiveProducts();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/category/{id}/products")
	public List<Product> getAllProductsByCategory(@PathVariable int id )
	{
		return productDAO.listActiveProductsByCategory(id);
	}

}
