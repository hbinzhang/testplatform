package com.zhb.test.springhibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ericsson.nfvo.dao.instance.VnfrDao;

public class Main {

	public static void main(String[] s) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();  
		ctx.register(com.ericsson.nfvo.ApplicationContext.class);
	    ctx.refresh();
	    VnfrDao v = (VnfrDao)ctx.getBean(VnfrDao.class);
		System.out.println("AnnotationConfigApplicationContext get by type is: " + v);
		
		VnfrDao v2 = (VnfrDao)ctx.getBean("instanceDao");
		System.out.println("AnnotationConfigApplicationContext get by name is: " + v2);
	}
}
