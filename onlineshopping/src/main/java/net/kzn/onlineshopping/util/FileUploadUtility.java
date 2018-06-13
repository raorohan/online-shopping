package net.kzn.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH="D:\\SpringProject\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images/";
	
	private static String REAL_PATH= "";

	//Adding Logger
	private static Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	public static void fileUpload(HttpServletRequest request,
			MultipartFile file, String code) {
		// TODO Auto-generated method stub
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images");
		logger.info(REAL_PATH);
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("real path is :-"+REAL_PATH);
		
		
		//we will have to check whther directories exist or not
		if(!new File(ABS_PATH).exists()){
			new File(ABS_PATH).mkdirs();	 	
			
		}
		
		if(!new File(REAL_PATH).exists()){
			new File(REAL_PATH).mkdirs();	 	
			
		}
		
		try{
			
			// upload to the server
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			
			//upload to project directory
			file.transferTo(new File(ABS_PATH+code+".jpg"));
			
		}catch(IOException ioex)
		{
			ioex.printStackTrace();
		}
	}

}
