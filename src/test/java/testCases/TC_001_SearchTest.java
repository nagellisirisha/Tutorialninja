package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_001_SearchTest extends BaseClass{

	@Test
	public void verifySearchProduct() {
		
		System.out.println("SearchTest Started");
		
		HomePage hp=new HomePage(driver);
		 
		hp.search("mac");
		
		SearchPage sp=new SearchPage(driver);
	
		boolean target=sp.areProductsDisplayed();
		
		
		boolean target1= sp.clickProduct("MacBook");
		
		
		Assert.assertTrue(target1);
		
	}
	
	@Test
	public void verifySearchProduct1() {
		
		System.out.println("SearchTest1 Started");
		
		HomePage hp=new HomePage(driver);
		 
		hp.search("caa");
		
		SearchPage sp=new SearchPage(driver);
	
		boolean target=sp.areProductsDisplayed();
		System.out.println(target);
		if(target==true) {
		Assert.assertTrue(target);
		}
		else {
		String txtNoProducts=sp.getNoProductMessage();
		
		Assert.assertEquals(txtNoProducts, "There is no product that matches the search criteria.");
		}                                

		
	}
}
