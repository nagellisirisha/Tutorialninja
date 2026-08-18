package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

	public class TC001_AccountLoginDDT extends BaseClass{
		@Test(dataProvider="LoginData",dataProviderClass = DataProviders.class,groups= {"datadriven"})
		public void verifyLogin(String email,String pwd,String exp) {
			logger.info("----------TC0001_AccountLogin Started------------");
			try {
			HomePage hp=new HomePage(driver);
			hp.clickAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmailAddress(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			MyAccountPage ap=new MyAccountPage(driver);
			boolean target=ap.isAccountLoggedIn();
			LogOutPage op = new LogOutPage(driver);

			if(exp.equalsIgnoreCase("valid")) {
				if(target==true) {
					ap.clickLogout();
					op.clickContinue();
					hp.clickAccount();
					hp.clickLogin();
				Assert.assertTrue(true);
				}
				else{
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid")) {
				if(target==true) {
					ap.clickLogout();
					op.clickContinue();
					hp.clickAccount();
					hp.clickLogin();
					System.out.println("invalid data, logged in: false");

					Assert.assertTrue(false);
				}
				else{
					System.out.println("invalid data, logged in: true");

					Assert.assertTrue(true);
				}
			}
			
//			Assert.assertTrue(target,"Invalid Login");
			
			
			
		}catch(Exception e) {
			Assert.fail();
		}
			logger.info("----------TC0001_AccountLogin Finished------------");
	}

}
