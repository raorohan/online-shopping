package net.kzn.onlineshopping.exception;

import java.io.Serializable;

public class CategoryNotFoundException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;
	
	public CategoryNotFoundException()
	{
		this("Category Not Avaialble");
	}
	
	public CategoryNotFoundException(String message)
	{
		this.message = System.currentTimeMillis() +": "+ message;
	}

}
