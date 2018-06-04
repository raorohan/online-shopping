package net.kzn.onlineshopping.controller;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PageController {
	
	//Importing Categories from Backend Project Using Spring DI
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView handle()
	{
		
		ModelAndView mav = new ModelAndView("main");
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
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		
		ModelAndView mav = new ModelAndView("main");
		
		Category category = null;
		category = categoryDAO.get(id);
		mav.addObject("title",category.getName());
		mav.addObject("categories", categoryDAO.list());
		mav.addObject("category", category);
		mav.addObject("userclickCategoryProducts",true);
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
