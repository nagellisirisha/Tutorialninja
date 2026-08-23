package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	Actions actions=new Actions(driver);
	public HomePage(WebDriver driver) {
		super(driver);
	}
 //--------------WebElements--------------
	@FindBy (xpath="//a[@title=\"My Account\"]")
	WebElement btnAccount;
	
	@FindBy (xpath="//a[normalize-space()=\"Register\"]")
	WebElement btnRegister;	
	@FindBy (xpath="//a[normalize-space()=\"Login\"]")
	WebElement btnLogin;	
	
	@FindBy (xpath="//input[@placeholder='Search']")
	WebElement inpSearch;
	
	@FindBy (xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnsearch;
	
//	@FindBy (xpath="//div[@class=\"collapse navbar-collapse navbar-ex1-collapse\"]//li[@class='dropdown']")
//	List<WebElement> hvrProductCategory;
	
	@FindBy (xpath="//div[@class='collapse navbar-collapse navbar-ex1-collapse']//div[@class='dropdown-menu']//a")
	List<WebElement> btnhvrSubProductCategory;
	
	@FindBy (xpath="//ul[@class='nav navbar-nav']/li")
	List<WebElement> btnproductCategory;


	
	
	
//	----------------Actions----------------
	
	public void clickAccount() {
		btnAccount.click();
	}
	public void clickRegister() {
		btnRegister.click();
	}
	public void clickLogin() {
		btnLogin.click();
	}
	
	
	public void search(String dataSearch) {
		inpSearch.clear();
		inpSearch.sendKeys(dataSearch);
		btnsearch.click();
		
	}
	
	public void selectCategory(String category,String subCategory) throws InterruptedException
	{
				 	
	    WebElement productCategory = btnproductCategory.stream()
	            .filter(e -> e.getText().trim().equalsIgnoreCase(category))
	            .findFirst()
	            .orElseThrow(() ->
	                    new RuntimeException("Category not found: " + category));
	 	   
	    
	    if(subCategory !=null && !subCategory.isEmpty())
	    {
	    	actions.moveToElement(productCategory).perform();
	      WebElement productSubCategory = btnhvrSubProductCategory.stream()
	            .filter(e -> e.getText().trim().equalsIgnoreCase(subCategory))
	            .findFirst()
	            .orElseThrow(() ->
	                    new RuntimeException("SubCategory not found: " + subCategory));
	   	    
	    actions.moveToElement(productSubCategory).click().perform();
	    }
	    else {
	    	productCategory.click();
	    }

		
	}

		
}
