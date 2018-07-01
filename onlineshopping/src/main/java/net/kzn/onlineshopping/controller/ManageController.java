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
import org.springframework.web.bind.annotation.PathVariable;
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
		
		// handle image validation for new products
		if(mproduct.getId() == 0)
		{
			// for new product addition
			new ProductValidator().validate(mproduct, result);
		}
		else {
			// for update product
						
			if(!mproduct.getFile().getOriginalFilename().equals(""))
			{
				// checking whether some uploading the correct file while updating product
				new ProductValidator().validate(mproduct, result);
			}
		}
		
		
		// check if there are any errors
		if(result.hasErrors())
		{
			
			model.addAttribute("title","Manage Products");
			model.addAttribute("userClickManageproducts",true);
			model.addAttribute("message","Validation failed for Product submission!");
			return "main";
		}
		// putting separate logic for adding and updating product
		if(mproduct.getId() == 0)
		{
			// Add the product
			productDAO.add(mproduct);
		}
		else{
			
			// Update product
			productDAO.update(mproduct);
		}
		
		
		if(!mproduct.getFile().getOriginalFilename().equals(""))
		{
			
			FileUploadUtility.fileUpload(request,mproduct.getFile(), mproduct.getCode() );
			
		}
		
		logger.info(mproduct.toString());
		return "redirect:/manage/products?operation=product";
	}
	
	
	// Admin:- Activating and deactivating the product
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	public String manageActivationOfProduct(@PathVariable("id") int id)
	{
		
		Product product = productDAO.get(id);
		boolean flag = product.isActive();
		if(flag){
			product.setActive(false);
			productDAO.update(product);
			return "Product Deactivated successfully";
		}
		else
		{
			product.setActive(true);
			productDAO.update(product);
			return "Product Deactivated successfully";
		}
		
				
	}
	
	// Manage Edit Product
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable("id") int id)
	{
		ModelAndView mav = new ModelAndView("main");
		// get the product from Database
		Product product = productDAO.get(id);
		mav.addObject("product", product);
		mav.addObject("title", "Manage Products");
		mav.addObject("userClickManageproducts", true);
		return mav;
		/*boolean flag = productDAO.update(product);
		if(flag){
			return "Product updated with Id"+product.getId();
		}
		return "SOmething went wrong";*/
	}
	
	// Manage Add category
	@RequestMapping(value="/add/category", method=RequestMethod.GET)
	public ModelAndView addNewCategory()
	{
		ModelAndView mav = new ModelAndView("main");
		
		Category category =  new Category();
		category.setName("Refrigerator");
		category.setActive(true);
		category.setDescription("Used for cooling stuffs");
		categoryDAO.add(category);
		
		return mav;
	}
	

}
