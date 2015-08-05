package com.zhb.test.onlyhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ericsson.nfvo.model.instance.VnfrJob;

public class Main {

	public static void main(String[] s) {
		 Configuration conf=new Configuration().configure();  
		 
         SessionFactory sf= conf.buildSessionFactory();  
         Session sess=sf.openSession();  
         Transaction tr=sess.beginTransaction();  
         sess.save(new VnfrJob(100, "20", "finished", "99", "1", "0", "1"));  
         tr.commit();  
         sess.close();  
         sf.close();  
	}
}
