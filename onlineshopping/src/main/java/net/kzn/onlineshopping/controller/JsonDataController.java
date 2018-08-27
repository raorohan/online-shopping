package net.kzn.onlineshopping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.kzn.onlineshopping.util.Employee;
import net.kzn.onlineshopping.util.TestRestAPI;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;




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
	
	// for Admin 
	@ResponseBody
	@RequestMapping(value="admin/all/products")
	public List<Product> getAllProductsForAdmin()
	{
		return productDAO.list();
	}
	
	
	//adding this for leaning
	@ResponseBody
	@RequestMapping(value="admin/all/test/{id}" , method = RequestMethod.POST)
	public ResponseEntity<TestRestAPI> testAPI(@PathVariable(value = "id") String id, @RequestBody Employee emp, @RequestHeader("Accept") String header)
	{
		System.out.println("Start The Correctmethod"+id+"Headder:- "+header);
		System.out.println(emp.getName() + emp.getAddress());
		TestRestAPI tar = new TestRestAPI();
		tar.setName("Deepak");
		tar.setPass("Chauhan");
		return new ResponseEntity<TestRestAPI>(tar,HttpStatus.OK);
	}
	@ResponseBody
	@RequestMapping(value="admin/all/productss", method = RequestMethod.GET)
	public void JustforTesting()
	{
		String url = "http://localhost:8080/onlineshopping/json/data/admin/all/test/rohan";
		       
        Employee employee = new Employee();
        employee.setAddress("Pune");
        employee.setName("Ishaan");
        
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		HttpEntity httpentity = new HttpEntity(headers);
		 ResponseEntity<TestRestAPI> entity = rest.postForEntity(url, employee, TestRestAPI.class, httpentity);
		 
		 System.out.println(entity.getBody().getName() + entity.getBody().getPass());
		
	}

}
