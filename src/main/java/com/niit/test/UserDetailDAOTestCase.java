package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
//import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDetailDAO;
//import com.niit.model.Category;
import com.niit.model.UserDetail;

public class UserDetailDAOTestCase {

	static UserDetailDAO userdetailDAO;
	@BeforeClass
	public static void executeFirst(){
		System.out.println("we are in execute first method");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		UserDetailDAO userdetailDAO =(UserDetailDAO)context.getBean("userdetailDAO" );
		if (userdetailDAO==null){
			System.out.println("user  null");
			
		}
		UserDetail userdetail=new UserDetail();
		
		userdetail.setUserName("U1");
		userdetail.setPassword("P1");
		userdetail.setAddress("sec-55");
		userdetail.setCustomerName("xyz");
		userdetail.setEmail("ab12@gmail.com");
		userdetail.setMobile("9876543210");
		userdetail.setEnabled("True");
		userdetail.setRole("User");

		if (userdetailDAO==null){
			System.out.println("user null 22");
		}

	System.out.println(userdetail.getUserName());
	System.out.println(userdetail.getPassword());
	System.out.println(userdetail.getAddress());
	System.out.println(userdetail.getCustomerName());
	System.out.println(userdetail.getEmail());
	System.out.println(userdetail.getMobile());
	System.out.println(userdetail.getEnabled());
	System.out.println(userdetail.getRole());
	userdetailDAO.registerUser(userdetail);
	}

	@Test
public void registerUserTest(){
	UserDetail userdetail=new UserDetail();

	userdetail.setUserName("U2");
	userdetail.setPassword("P2");
	if (userdetailDAO==null){
		System.out.println("user null 22");
	}

System.out.println(userdetail.getUserName());
System.out.println(userdetail.getPassword());
System.out.println(userdetail.getAddress());
System.out.println(userdetail.getCustomerName());
System.out.println(userdetail.getEmail());
System.out.println(userdetail.getMobile());
System.out.println(userdetail.getEnabled());
System.out.println(userdetail.getRole());
	assertTrue("problem in adding user:",userdetailDAO.registerUser(userdetail));	
}
}
