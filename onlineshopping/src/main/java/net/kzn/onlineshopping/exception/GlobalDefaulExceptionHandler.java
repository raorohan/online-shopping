package net.kzn.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaulExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFOundException()
	{
		ModelAndView mav = new ModelAndView("unknown");
		mav.addObject("errorTitle","Unknown Page");
		mav.addObject("errorDescription", "The page you are looking for in not available.!!!");
		mav.addObject("title","404 Error :- Page Not Available");
		return mav;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mav = new ModelAndView("unknown");
		mav.addObject("errorTitle","Product Unavailable");
		mav.addObject("errorDescription", "The product you are looking for in not available.!!!");
		mav.addObject("title","404 Error :- Product Not Available");
		return mav;
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ModelAndView handlerCategoryNotFoundException()
	{
		ModelAndView mav = new ModelAndView("unknown");
		mav.addObject("errorTitle","Category Unavailable");
		mav.addObject("errorDescription", "The Product Category you are looking for in not available.!!!");
		mav.addObject("title","404 Error :- Category Not Available");
		return mav;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView mav = new ModelAndView("unknown");
		/*Only for debugging*/
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);	
		ex.printStackTrace(pw);
		/*Only for debugging*/
		mav.addObject("errorTitle","Contact your Administrator!!!");
		mav.addObject("errorDescription", ""+ex.toString());
		mav.addObject("title"," Error");
		return mav;
	}

}
