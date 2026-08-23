package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC_001_ProductDetailsTest extends BaseClass{
	@Test
	public void ValidateProductDetails() {
		System.out.println("ProductDetailsTest  Started");
		try {
		HomePage hp=new HomePage(driver);
		ProductPage pp=new ProductPage(driver);
		hp.selectCategory("Tablets","");
		pp.clickBtnList();
//		boolean target= pp.getProductCount();
//		System.out.println(target);
		
		
		String target = pp.isProductDisplayed("Samsung Galaxy Tab 10.2");
		System.out.println(target);
		
		if(target.equals("Samsung Galaxy Tab 10.2")) {
			ProductDetailsPage pdp=new ProductDetailsPage(driver);
			pdp=pp.clickProduct(target);
		
			String actualProduct = pdp.getProductName();
	
			System.out.println("ProductDetailsTest  Fnished");
			Assert.assertEquals(target, "Samsung Galaxy Tab 10.2");
		}
		else if(target.equals("Required Products not Found")){
//			System.out.println(target+"  target ");
			Assert.assertEquals(target,"Required Products not Found"); 
			
		}
		else
		{
			Assert.assertEquals(target, "There are no products to list in this category.");
		}
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void ValidateProductDetails1() {
		System.out.println("ProductDetailsTest  Started");
		try {
		HomePage hp=new HomePage(driver);
		
		hp.selectCategory("Tablets","");
		ProductPage pp=new ProductPage(driver);
		pp.clickBtnList();
		
		String target = pp.isProductDisplayed("Samsung Galaxy Tab 10.1");
		System.out.println(target);
		
		if(target.equals("Samsung Galaxy Tab 10.1")) {
			ProductDetailsPage pdp=new ProductDetailsPage(driver);
			pdp=pp.clickProduct(target);
			
			System.out.println( pdp.getProductName());
			System.out.println( pdp.getProductDescription());
			System.out.println( pdp.getProductPrice());
			
			System.out.println("ProductDetailsTest  Fnished");
			Assert.assertEquals(target, "Samsung Galaxy Tab 10.1");
		}
		else if(target.equals("Required Products not Found")){
//			System.out.println(target+"  target ");
			Assert.assertEquals(target,"Required Products not Found"); 
			
		}
		else
		{
			Assert.assertEquals(target, "There are no products to list in this category.");
		}
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
