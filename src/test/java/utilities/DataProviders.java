package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="SearchData")
	public String[][] getdata() throws IOException
	{
		
		String path = ".\\testData\\TutorialninjaLoginData.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrow = xlutil.getRowCount("Search");
		int totalcol = xlutil.getCellCount("Search", 0);
		
		String logindata[][] = new String[totalrow][totalcol];
		
		for(int i=1;i<=totalrow;i++)
		{
			for(int j=0;j<totalcol;j++)
			{
				logindata[i-1][j] = xlutil.getCellData("Search", i, j);
			}
		}
	return logindata;
		
	}
}
