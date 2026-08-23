package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage{
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy (xpath="//input[@id='input-search']")
	WebElement inpSearch;
	@FindBy (xpath="//input[@id='button-search']")
	WebElement btnsearch;
	@FindBy (xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement searchcriteria;
	
	
	@FindBy (xpath="//input[@name='sub_category']")
	WebElement chkSubCategory;
	@FindBy (xpath="//input[@id='description']")
	WebElement chkProdDescription;
	@FindBy (xpath="(//div[@class='row'])[5]//div[@class='product-thumb']//h4/a")
	List<WebElement> btnProductNames;
	
	
	

	public void setSearchKeyword(String searchtxt) {
		inpSearch.clear();
		inpSearch.sendKeys(searchtxt);
	}
	
	public void ClickSearch() {
		btnsearch.click();
	}
	
	
	 public boolean areProductsDisplayed() {

	        return btnProductNames.size() > 0;
	    }
	 public String getNoProductMessage() {

	        return searchcriteria.getText();
	    }
	
	public boolean clickProduct(String productName) {
		try {
			
		for(WebElement product:btnProductNames) {
			
			if(product.getText().equalsIgnoreCase(productName))
			{
				product.click();
				return true;
			}
		}
		
		return false;
		
		}
		catch(Exception e) {
			return false;
		}

		
	}
	
	
}
