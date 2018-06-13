package net.kzn.onlineshopping.validator;

import net.kzn.shoppingbackend.dto.Product;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		// TODO Auto-generated method stub
		Product product = (Product)target;
		
		
		// validating for image file
		
		if(product.getFile().getOriginalFilename().equals(""))
		{
			error.rejectValue("file", null, "Please select an image to upload");
			return;
		}
		
		if( !((product.getFile().getContentType().equals("image/jpeg")) || 
				(product.getFile().getContentType().equals("image/gif")) ||
				(product.getFile().getContentType().equals("image/png"))
				)){
			error.rejectValue("file", null, "Please use only image file to upload");
		}

	}

}
