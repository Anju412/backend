package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
@Repository("catDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	
 @Autowired
 SessionFactory sessionFactory;

	public boolean addCategory(Category category) 
	{
	 try
	 {
		 System.out.println("we are in add category method.");
		 sessionFactory.getCurrentSession().save(category);
		 return true;
	 }
	 catch(Exception e){
		return false;
	}
	}

	public boolean updateCategory(Category category)
	{ try
	 {
		 sessionFactory.getCurrentSession().update(category);
		 return true;
	 }
	catch(Exception e){
		return false;
	}
	}
	public boolean deleteCategory(Category category)
	{
		 try
		 {
			 sessionFactory.getCurrentSession().delete(category);
			 return true;
		 }
		 catch(Exception e){
		return false;
	}
	}

	public Category getCategory(int categoryId) 
	{
	    try
	    {
	    	Session session=sessionFactory.getCurrentSession();
	    	Category category=(Category)session.get(Category.class, categoryId);
	    	return category;
	       }
	    catch(Exception e){
		return null;
	}
	}
	public List<Category> listCategories()
	{
		try
		{
			System.out.println("we are in list categories method of daoimpl");
			Session session=sessionFactory.getCurrentSession();
		    Query query=session.createQuery("from Category");
			List<Category> listCategories=query.list();
			//session.close();
 		    return listCategories;
		}
		catch(Exception e)
		{
		return null;
	}
	}

}
