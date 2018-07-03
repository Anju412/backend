
	package com.niit.test;

	import static org.junit.Assert.assertTrue;

	import org.junit.BeforeClass;
	import org.junit.Ignore;
	import org.junit.Test;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	import com.niit.dao.ProductDAO;
	import com.niit.model.Product;

	public class ProductDAOTestCase {

	static ProductDAO productDAO;
		
		@BeforeClass
		public static void executefirst(){

			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
			
			ProductDAO productDAO =(ProductDAO)context.getBean("productDAO");
			if(productDAO==null)
			{
				System.out.println("Category null");
			}
			Product product=new Product();
			product.setProductName("Samsung J7");
			product.setProductDesc("Samsung Mobile with 4G Features");
			product.setPrice(14000);
			product.setStock(27);
			product.setCategoryId(1);
			product.setSupplierId(1);
			
			System.out.println(product.getProductId());
			System.out.println(product.getProductName());
			System.out.println(product.getProductDesc());
		    System.out.println(product.getPrice());
			System.out.println(product.getStock());
			System.out.println(product.getCategoryId());
			System.out.println(product.getSupplierId());
			productDAO.addProduct(product);
		}
		//	assertTrue("Problem in Adding Product",productDAO.addProduct(product));
		
			
		/*	System.out.println("delete method");
			Product product=productDAO.getProduct(35);
			System.out.println(product.getProductName());
			System.out.println(product.getProductDesc());
			System.out.println(product.getPrice());
			System.out.println(product.getStock());
			System.out.println(product.getCategoryId());
			System.out.println(product.getProductId());
			System.out.println(product.getSupplierId());

			productDAO.deleteProduct(product);
		}*/
			
			/*Product product=productDAO.getProduct(36);
			product.setProductName("Samsung");
			product.setProductDesc("Samsung smart mobiles with 4G Features");
			System.out.println(product.getProductId());
			System.out.println(product.getProductName());
			System.out.println(product.getProductDesc());
		    System.out.println(product.getPrice());
			System.out.println(product.getStock());
			System.out.println(product.getCategoryId());
			System.out.println(product.getSupplierId());
			productDAO.updateProduct(product);*/
		   
		//assertTrue("Problem in updating the category",categoryDAO.updateCategory(category));
	

		
		@Test
		public void addProductTestCase()
		{
			Product product=new Product();
			product.setProductName("Samsung J7");
			product.setProductDesc("Samsung Mobile with 4G Features");
			product.setPrice(12000);
			product.setStock(20);
			product.setCategoryId(1);
			product.setSupplierId(1);
			
			assertTrue("Problem in Adding Product",productDAO.addProduct(product));
			
		}
	}



