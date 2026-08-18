package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath="//input[@id=\"input-email\"]")
	WebElement inpEmailAddress;
	@FindBy (xpath="//input[@id=\"input-password\"]")
	WebElement inpPassword;
	@FindBy (xpath="//input[@value=\"Login\"]")
	WebElement btnLogin;
	

	public void setEmailAddress(String mail) {
		inpEmailAddress.sendKeys(mail);
		
	}
	public void setPassword(String pwd) {
		inpPassword.sendKeys(pwd);
	}
	public void clickLogin() {
		btnLogin.click();
	}
	
	
}
