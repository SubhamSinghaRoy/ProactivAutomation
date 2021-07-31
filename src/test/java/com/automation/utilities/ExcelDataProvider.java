package com.automation.utilities;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	
	@DataProvider(name="LoginData")
	public Object [][] getData() throws Exception{
		
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

	//Adding more dataproviders
	@DataProvider(name="OrderDetails")
	public Object[][] getSystemData() throws Exception {
		String path = "./TestData/Data.xlsx";
		XLUtility xlutil = new XLUtility(path);
		String sysName = xlutil.getCellData("product_details",1,0);
		String sysCat = xlutil.getCellData("product_details",1,1);
		String supply = xlutil.getCellData("product_details",1,2);
		String kiName = xlutil.getCellData("product_details",1,3);
		return new Object[][]{{sysName,sysCat,supply,kiName}};
	}

	@DataProvider(name="ShippingDetails")
	public Object[][] getShippingData() throws Exception {
		String path = "./TestData/Data.xlsx";
		XLUtility xlutil = new XLUtility(path);
		String firstName = xlutil.getCellData("shipping_address",1,0);
		String lastName = xlutil.getCellData("shipping_address",1,1);
		String address = xlutil.getCellData("shipping_address",1,2);
		String city = xlutil.getCellData("shipping_address",1,3);
		String state = xlutil.getCellData("shipping_address",1,4);
		String zip = xlutil.getCellData("shipping_address",1,5);
		String phone = xlutil.getCellData("shipping_address",1,6);
		String shipping = xlutil.getCellData("shipping_address",1,7);
		return new Object[][]{{firstName,lastName,address,city,state,zip,phone,shipping}};
	}

	@DataProvider(name="CCDetails")
	public Object[][] getCardData() throws Exception {
		String path = "./TestData/Data.xlsx";
		XLUtility xlutil = new XLUtility(path);
		String cardType = xlutil.getCellData("credit_card",1,0);
		String cardNum = xlutil.getCellData("credit_card",1,1);
		String cardName = xlutil.getCellData("credit_card",1,2);
		String month = xlutil.getCellData("credit_card",1,3);
		String year = xlutil.getCellData("credit_card",1,4);
		String cvv = xlutil.getCellData("credit_card",1,5);
		return new Object[][]{{cardType,cardNum,cardName,month,year,cvv}};
	}

	@DataProvider(name="accountDetails")
	public Object[][] getaAccountData() throws Exception {
		String path = "./TestData/Data.xlsx";
		XLUtility xlutil = new XLUtility(path);
		String email = xlutil.getCellData("account_details",1,0);
		String pass = xlutil.getCellData("account_details",1,1);
		return new Object[][]{{email,pass}};
	}
}