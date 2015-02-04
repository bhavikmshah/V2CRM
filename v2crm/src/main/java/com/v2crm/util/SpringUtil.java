package com.v2crm.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {

	private  ApplicationContext applicationContext;;
	private static SpringUtil springUtil = new SpringUtil();
	
	private SpringUtil(){
		try {
			applicationContext = new ClassPathXmlApplicationContext("appContext.xml");
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public  Object getService(String service){
		return applicationContext.getBean(service);
	}
	
	
    public static SpringUtil getSpringUtil(){
    	if(springUtil == null){
    		springUtil = new SpringUtil();
    	}
    	return springUtil;
    }
   
}
