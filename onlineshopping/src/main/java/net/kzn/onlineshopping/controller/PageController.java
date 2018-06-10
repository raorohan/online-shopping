package net.kzn.onlineshopping.controller;

import net.kzn.onlineshopping.exception.CategoryNotFoundException;
import net.kzn.onlineshopping.exception.ProductNotFoundException;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PageController {
	
	public static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	//Importing Categories from Backend Project Using Spring DI
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		
		ModelAndView mav = new ModelAndView("main");
		logger.info("Inside Page Controller Index Method - INFO ");
		logger.debug("Inside Page Controller Index Method - INFO ");
		mav.addObject("title","Home");
		mav.addObject("categories", categoryDAO.list());
		mav.addObject("userclickhome",true);
		return mav;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		
		ModelAndView mav = new ModelAndView("main");
		mav.addObject("title","About Us");
		mav.addObject("userClickAbout",true);
		return mav;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		
		ModelAndView mav = new ModelAndView("main");
		mav.addObject("title","Contact Us");
		mav.addObject("userClickContact",true);
		return mav;
	}
	
	/*Methods to load all the products based on their category*/
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts()
	{
		
		ModelAndView mav = new ModelAndView("main");
		mav.addObject("title","All Products");
		mav.addObject("categories", categoryDAO.list());
		mav.addObject("userclickAllProducts",true);
		return mav;
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) throws CategoryNotFoundException
	{
		
		ModelAndView mav = new ModelAndView("main");
		
		Category  category = categoryDAO.get(id);
		if(category == null) throw new CategoryNotFoundException();
		mav.addObject("title",category.getName());
		mav.addObject("categories", categoryDAO.list());
		mav.addObject("category", category);
		mav.addObject("userclickCategoryProducts",true);
		return mav;
	}
	
	
	/*Viewing a single Prodict*/
	
	@RequestMapping(value="/show//{id}/product")
	public ModelAndView showSingleProductById(@PathVariable("id") int id) throws ProductNotFoundException
	{
		
		ModelAndView mav = new ModelAndView("main");
		
		Product product = productDAO.get(id);
		if(product == null) throw new ProductNotFoundException();
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		mav.addObject("product",product);
		mav.addObject("title",product.getName());
		
		mav.addObject("userClickShowProduct",true);
		return mav;
	}
	// This was demonstration only
	/*@RequestMapping(value="/test")
	public ModelAndView test1(@RequestParam(value="greeting",required=false)String greeting)
	{
		
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("greeting",greeting);
		return mav;
	}
	
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greeting)
	{
		
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("greeting",greeting);
		return mav;
	}*/
}
