package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//div[@id='content']//h1")
	WebElement productName;
	
	@FindBy (xpath="//ul[@class='list-unstyled']/li/h2")
	WebElement productPrice;
	
	@FindBy (xpath="//div[@id='tab-description']")
	WebElement productDescription;
	
	@FindBy (xpath="//button[@id='button-cart']")
	WebElement btnAddtoCart;
	
	public String getProductName() {
		return productName.getText();
	}
	
	public String getProductPrice() {
		return productPrice.getText();
	}
	
	public String getProductDescription() {
		return productDescription.getText();
	}
	
	public void clickAddToCart() {
		 btnAddtoCart.click();
	}
	
	

}
