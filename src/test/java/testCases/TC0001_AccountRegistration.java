package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC0001_AccountRegistration extends BaseClass{
	

	@Test(groups={"master","regression"})
	public void verifyRegister() {
		logger.info("------ TC0001_AccountRegistration Started -------");
		HomePage hp= new HomePage(driver);
		hp.clickAccount();
		hp.clickRegister();
		
		RegisterPage rp=new RegisterPage(driver);
		rp.setFirstName(randomAlpha(4));
		rp.setLasttName(randomAlpha(2));
		rp.setEmail((String)new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())+"@gmail.com");
		rp.setTelephone(randomNumber(10));
		String password=randomAlpha(4)+randomNumber(4);
		rp.setPassword(password);
		rp.setConfirmPassword(password);
		rp.checkPolicy();
		rp.clickContinue();
		boolean target = rp.isRegistered();
		logger.info("------ TC0001_AccountRegistration Finished -------");
		Assert.assertTrue(target);
	}

}
