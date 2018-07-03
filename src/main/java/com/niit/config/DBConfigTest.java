package com.niit.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class DBConfigTest {
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("catDAO");
		Category category=new Category();
		category.setCategoryName("Mobile");
		category.setCategoryDesc("Samsung Mobile");
		System.out.println("we are after set category..");
		categoryDAO.addCategory(category);
		
		System.out.println("Category Object Saved");
	}

}
