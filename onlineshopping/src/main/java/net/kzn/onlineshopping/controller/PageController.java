package net.kzn.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PageController {
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView handle()
	{
		
		ModelAndView mav = new ModelAndView("main");
		mav.addObject("title","Home");
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
