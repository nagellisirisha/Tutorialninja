package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC0001_AccountLogin extends BaseClass{
	@Test(groups={"master","sanity"})
	public void verifyLogin() {
		logger.info("----------TC0001_AccountLogin Started------------");
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress("sirisha14@gmail.com");
		lp.setPassword("sirisha");
		lp.clickLogin();
		
		MyAccountPage ap=new MyAccountPage(driver);
		boolean target=ap.isAccountLoggedIn();
		
		logger.info("----------TC0001_AccountLogin Finished------------");
		Assert.assertTrue(target,"Invalid Login");
		
		
		
	}
}
