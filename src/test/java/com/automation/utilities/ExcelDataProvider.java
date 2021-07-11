package com.automation.utilities;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	
	@DataProvider(name="LoginData")
	public String [][] getData() throws Exception{
		
		String path = "./TestData/Data.xlsx";
		XLUtility xlutil = new XLUtility(path);
		int totalRows = xlutil.getRowCount("Login");
		int totalCols = xlutil.getCellCount("Login",1);
		
		String loginData[][] = new String[totalRows][totalCols];
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				loginData[i-1][j] = xlutil.getCellData("Login", i, j);
			}
		}
		return loginData;
		
	}
}