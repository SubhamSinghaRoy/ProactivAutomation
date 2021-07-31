package com.automation.utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class OrderDetails {

    File src = new File("./TestData/Data.xlsx");
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    Row row;
    XLUtility util = new XLUtility("./TestData/Data.xlsx");;;
    {
        try {
            fis = new FileInputStream(src);
            wb  = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }


    public String getSysName() throws Exception{
        String sysName = util.getCellData("product_details",1,0);
        return sysName;
    }

    public String getSysCat() throws Exception{
        String sysCat = util.getCellData("product_details",1,1);
        return sysCat;
    }
    public String getSupply() throws Exception{
        String supply = util.getCellData("product_details",1,2);
        return supply;
    }
    public String getKitName() throws Exception{
        String kitName = util.getCellData("product_details",1,3);
        return kitName;
    }

    public String getFirstName()throws Exception{
        String firstName = util.getCellData("shipping_address",1,0);
        return firstName;
    }

    public String getLastName()throws Exception{
        String lastName = util.getCellData("shipping_address",1,1);
        return lastName;
    }

    public String getAddress()throws Exception{
        String address = util.getCellData("shipping_address",1,2);
        return address;
    }

    public String getCity()throws Exception{
        String city = util.getCellData("shipping_address",1,3);
        return city;
    }

    public String getState()throws Exception{
        String state = util.getCellData("shipping_address",1,4);
        return state;
    }

    public String getZip()throws Exception{
        String zip = util.getCellData("shipping_address",1,5);
        return zip;
    }

    public String getPhone()throws Exception{
        String phone = util.getCellData("shipping_address",1,6);
        return phone;
    }

    public String getShipping()throws Exception{
        String shipping = util.getCellData("shipping_address",1,7);
        return shipping;
    }

    public String getCardType()throws Exception{
        String cardType = util.getCellData("credit_card",1,0);
        return cardType;
    }

    public String getCardNum()throws Exception{
        String cardNum = util.getCellData("credit_card",1,1);
        return cardNum;
    }

    public String getCardName()throws Exception{
        String cardName = util.getCellData("credit_card",1,2);
        return cardName;
    }

    public String getMonth()throws Exception{
        String month = util.getCellData("credit_card",1,3);
        return month;
    }

    public String getYear()throws Exception{
        String year = util.getCellData("credit_card",1,4);
        return year;
    }

    public String getCVV()throws Exception{
        String cvv = util.getCellData("credit_card",1,5);
        return cvv;
    }

    public String getEmail()throws Exception{
        String email = util.getCellData("account_details",1,0);
        return email;
    }

    public String getPass()throws Exception{
        String pass = util.getCellData("account_details",1,1);
        return pass;
    }

//    public static void main(String[] args) throws Exception{
//        OrderDetails od = new OrderDetails();
//        System.out.println(od.getPass());
//    }
}
