package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_SearchTest_DDT extends BaseClass{

	@Test(dataProvider ="SearchData",dataProviderClass = DataProviders.class)
	public void ValidateSearchData(String searchText,String exp)
	{
		try {
		System.out.println("text "+searchText);
		System.out.println("SearchTestDDT Started");
		HomePage hp=new HomePage(driver);
		hp.search(searchText);
		SearchPage shpage = new SearchPage(driver);
		
		boolean target=shpage.areProductsDisplayed();
		boolean expected=Boolean.parseBoolean(exp);
		
		Assert.assertEquals(target, expected);
		
		
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
	
}
