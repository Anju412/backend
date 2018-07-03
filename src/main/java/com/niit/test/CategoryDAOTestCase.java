package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTestCase {

static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executefirst(){
        System.out.println("we are in execute first");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("catDAO");
		if(categoryDAO==null)
		{
			System.out.println("category null");
		}
		
		/*Category category=new Category();
		category.setCategoryName("t-shirt");
		category.setCategoryDesc("Vanhusen Shirt");
		if(categoryDAO==null)
		{
			System.out.println("Category null");
		}
		System.out.println(category.getCategoryId());
		System.out.println(category.getCategoryName());
		System.out.println(category.getCategoryDesc());
		categoryDAO.addCategory(category);
	}
	
	System.out.println("delete method");
	Category category=categoryDAO.getCategory(2);
	System.out.println(category.getCategoryId());
	System.out.println(category.getCategoryName());
	System.out.println(category.getCategoryDesc());
	categoryDAO.deleteCategory(category);
	assertTrue("Problem in deleting the category",categoryDAO.deleteCategory(category));
	
	}
	Category category=categoryDAO.getCategory(34);
	category.setCategoryName("Samsung");
	category.setCategoryDesc("Samsung smart mobiles with 4G Features");
	//System.out.println(category.getCategoryId());
	//System.out.println(category.getCategoryName());
	//System.out.println(category.getCategoryDesc());
    categoryDAO.updateCategory(category);
//assertTrue("Problem in updating the category",categoryDAO.updateCategory(category));
	}*/
		List<Category> listCategories=categoryDAO.listCategories();
		//categoryDAO.listCategories();
		for(Category categories:listCategories){
			System.out.println(categories.getCategoryId());
		}
	}
	
@Ignore	
@Test
public void updateCategoryTest()
{
//	Category category=categoryDAO.getCategory(1);
//	category.setCategoryName("Samsung");
//	category.setCategoryDesc("Samsung smart mobiles with 4G Features");
//assertTrue("Problem in updating the category",categoryDAO.updateCategory(category));
}

@Test
public void deleteCategoryTest()
{
	Category category=categoryDAO.getCategory(2);
	System.out.println(category.getCategoryId());
	System.out.println(category.getCategoryName());
	System.out.println(category.getCategoryDesc());
	categoryDAO.addCategory(category);
	assertTrue("Problem in deleting the category",categoryDAO.deleteCategory(category));
	
}
/*@Ignore
@Test
public void listCategoriesTest()
{
	try
	{
	List<Category> listCategories=categoryDAO.listCategories();
	assertTrue("Problem in listing the category",listCategories.size()>0);
	for(Category category:listCategories)
	{

		System.out.println(category.getCategoryId()+":::");
		System.out.println(category.getCategoryName()+":::");
		System.out.println(category.getCategoryDesc()+":::");

	}
	}
	catch(Exception e)
	{
	 System.out.println("Exception");
	}
}*/
}



