package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	@FindBy (xpath="//h2[normalize-space()=\"My Account\"]")
	WebElement txtMyAccount;
	@FindBy (xpath="//a[@class=\"list-group-item\"][normalize-space()=\"Logout\"]")
	WebElement btnLogout;
	
	public void clickLogout() {
		btnLogout.click();
	}
	
	
	public boolean isAccountLoggedIn() {
		try {
		String target=txtMyAccount.getText();
		if(target.equals("My Account")) {
			return true;
		}
		}
		catch(Exception e) {
			
		}
		return false;
	}
	
}
