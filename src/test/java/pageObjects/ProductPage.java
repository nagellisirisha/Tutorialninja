package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	//all product images
	@FindBy (xpath="(//div[@class='row'])[6]//img")
	List<WebElement> productImages; 
	//all product names
	@FindBy (xpath="//div[@class='caption']//a")
	List<WebElement> productNames; 
	
	@FindBy (xpath="//button[@id='list-view']")
	WebElement btnlist;
	//all cart for the products
	@FindBy (xpath="(//div[@class='row'])[6]//i[@class=\"fa fa-shopping-cart\"]")
	List<WebElement> btnproductAddtoCart; 
	//all wishlist for the products
	@FindBy (xpath="(//button[@data-original-title=\"Add to Wish List\"])")
	List<WebElement> btnproductWishList; 
	//all product compare for the products
	@FindBy (xpath="(//button[@data-original-title=\"Compare this Product\"])")
	List<WebElement> btnproductCompare; 
	
	@FindBy (xpath="//p[normalize-space()='There are no products to list in this category.']")
	WebElement txtNoProducts;
	
	@FindBy (xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement txtConfirmMessage;
	
	
	
	
	
	public void clickBtnList() {
		btnlist.click();
	}
	
// -------- Numbers of Products Available in ProductPage ------------
	
	public boolean getProductCount() {
//		System.out.println(productNames);
		return productNames.size()>0;
	}
	
// --------- If required product is found in productPage 
//	it returns same productName or returns no products String  ----------
	
	public String isProductDisplayed(String productName) {
		
		if(productNames!=null && !productNames.isEmpty())
		{
				
	        for (WebElement product : productNames) {
	
	            if (product.getText().equalsIgnoreCase(productName)) {
	                return product.getText();
	            }
	        }
	        return "Required Products not Found";
		}
			return txtNoProducts.getText();
    }
	
//	--------- prints Product names in product page ------------------
	
//	public void printProductNames() {
//
//        for (WebElement product : productNames) {
//
//            System.out.println(product.getText());
//        }
//    }
	
//-------After required Product is clicked  goes to product details page -------------
	
	public ProductDetailsPage clickProduct(String productName) {
		try {
			
        for (WebElement product : productNames) {

            if (product.getText().equalsIgnoreCase(productName)) {
            	product.click();

                return new ProductDetailsPage(driver);
            }
        }
		}
		catch(Exception e) {
			
		}
		System.out.println("No Products FOund " + productName);
		return null;
       
    }
	
	public int indexOfProduct(String productName) {
		int index=-1;
		
		for (int i=0;i<productNames.size();i++) {
			WebElement product =productNames.get(i);
            if (product.getText().equalsIgnoreCase(productName)) {
            	product.click();
            	index= i;
            }
        }
		return index;
	}
	
	public String clickWishList(String productName) {
		int i= indexOfProduct(productName);
		btnproductWishList.get(i).click();
		return txtConfirmMessage.getText();
	}
	
	
}
