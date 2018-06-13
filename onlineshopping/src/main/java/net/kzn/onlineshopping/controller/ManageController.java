package net.kzn.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.kzn.onlineshopping.util.FileUploadUtility;
import net.kzn.onlineshopping.validator.ProductValidator;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/manage")
public class ManageController {
	
	
	@Autowired 
	private CategoryDAO categoryDAO;
	
	@Autowired 
	private ProductDAO productDAO;
	
	public static final Logger logger = LoggerFactory.getLogger(ManageController.class);
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView manageProduct(@RequestParam(name="operation", required=false) String operation)
	{
		System.out.println("in correct method");
		ModelAndView mav = new ModelAndView("main");
		
		mav.addObject("title","Manage Products");
		mav.addObject("userClickManageproducts",true);
		
		Product newProduct = new Product();
		newProduct.setActive(true);
		newProduct.setSupplierId(1);
		
		mav.addObject("product", newProduct);
		
		if(operation != null)
		{
			if("product".equals(operation))
			{
				mav.addObject("message","Product submitted successfully");
			}
		}
		
		return mav;
	}
	
	// return categories for all the list
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDAO.list();
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mproduct, BindingResult result, Model model, HttpServletRequest request)
	{
		
		new ProductValidator().validate(mproduct, result);
		
		// check if there are any errors
		if(result.hasErrors())
		{
			
			model.addAttribute("title","Manage Products");
			model.addAttribute("userClickManageproducts",true);
			model.addAttribute("message","Validation failed for Product submission!");
			return "main";
		}
		productDAO.add(mproduct);
		
		if(!mproduct.getFile().getOriginalFilename().equals(""))
		{
			
			FileUploadUtility.fileUpload(request,mproduct.getFile(), mproduct.getCode() );
			
		}
		
		logger.info(mproduct.toString());
		return "redirect:/manage/products?operation=product";
	}
	

}
