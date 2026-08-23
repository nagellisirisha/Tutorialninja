package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HeaderPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC_001_ProductTest extends BaseClass{

	@Test(priority=1)
	public void validateProduct() throws InterruptedException {
		System.out.println("validateProduct  Started");
		
		HomePage hp=new HomePage(driver);
		
		hp.selectCategory("Tablets","");
		ProductPage pp= new ProductPage(driver);
//		pp.clickBtnList();
		
		String target=pp.isProductDisplayed("Samsung Galaxy Tab 10.1");
//		boolean target= pp.getProductCount();
		System.out.println(target);
		System.out.println("validateProduct  Fnished");
		
		Assert.assertEquals(target,"Samsung Galaxy Tab 10.1");
		
	}
	
	@Test(priority=0)
	public void verifyWishList() throws InterruptedException {
		System.out.println("verifyWishList  Started");
		
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress("sirisha14@gmail.com");
		lp.setPassword("sirisha");
		
		hp.selectCategory("Desktops","Mac (1)");
		ProductPage pp= new ProductPage(driver);
//		pp.clickBtnList();
		
		String productdetail=pp.isProductDisplayed("iMac");
//		boolean target= pp.getProductCount();
		System.out.println(productdetail);
		System.out.println("verifyWishList  Fnished");
		
		
		String target = pp.clickWishList("iMac");
		System.out.println(target);
		Assert.assertTrue(target.contains("You must login or create an account "));
		
	}
	
	@Test(priority=2)
	public void validateNoProductFound() throws InterruptedException {
		System.out.println("validateNoProductFound  Started");
		
		HomePage hp=new HomePage(driver);
		hp.selectCategory("Desktops","PC (0)");
		ProductPage pp= new ProductPage(driver);
//		pp.clickBtnList();
		
		String target=pp.isProductDisplayed("Samsung Galaxy Tab 10.1");
//		boolean target= pp.getProductCount();
		System.out.println(target);
		System.out.println("validateNoProductFound  Fnished");
		
		Assert.assertEquals(target,"There are no products to list in this category.");
		
	}
	
	@Test(priority=3)
	public void validateProducts() throws InterruptedException {
		System.out.println("validateProducts  Started");
		
		HomePage hp=new HomePage(driver);
		hp.selectCategory("Tablets","");
		ProductPage pp= new ProductPage(driver);
//		pp.clickBtnList();
		
		String target=pp.isProductDisplayed("Samsung Galaxy Tab 10.2");
//		boolean target= pp.getProductCount();
		System.out.println(target);
		System.out.println("validateProducts  Fnished");
		
		Assert.assertEquals(target,"Required Products not Found");
		
	}
}


