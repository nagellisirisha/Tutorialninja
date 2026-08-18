package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
//-----------------WebElements --------
@FindBy (xpath="//input[@id=\"input-firstname\"]")
WebElement inpFirstName;
@FindBy (xpath="//input[@id=\"input-lastname\"]")
WebElement inpLastName;
@FindBy (xpath="//input[@id=\"input-email\"]")
WebElement inpEmail;
@FindBy (xpath="//input[@id=\"input-telephone\"]")
WebElement inpTelephone;
@FindBy (xpath="//input[@id=\"input-password\"]")
WebElement inpPassword;
@FindBy (xpath="//input[@id=\"input-confirm\"]")
WebElement inpConfirmPassword;
@FindBy (xpath="//input[@name=\"agree\"]")
WebElement inpPolicy;
@FindBy (xpath="//input[@value=\"Continue\"]")
WebElement btnContinue;
@FindBy (xpath="//h1[normalize-space()=\"Your Account Has Been Created!\"]")
WebElement confirmMessage;






//-----------------Actions --------
	public void setFirstName(String fname) {
		inpFirstName.sendKeys(fname);
	}
	public void setLasttName(String lname) {
		inpLastName.sendKeys(lname);
	}
	public void setEmail(String mail) {
		inpEmail.sendKeys(mail);
	}
	public void setTelephone(String ContactNumber) {
		inpTelephone.sendKeys(ContactNumber);
	}
	public void setPassword(String pwd) {
		inpPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String cpwd) {
		inpConfirmPassword.sendKeys(cpwd);
	}
	public void checkPolicy() {
		inpPolicy.click();
	}
	public void clickContinue() {
		btnContinue.click();
	}
	
	public boolean isRegistered() {
		if(confirmMessage.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
