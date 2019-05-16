package ui;

import org.apache.poi.hssf.usermodel.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pages.EbayTXTXLSPage;
import web.driver.factory.DriverFactory;
import java.io.FileOutputStream;
import java.util.*;

public class EbayTXTXLSPageTest extends EbayTXTXLSPage {
    EbayTXTXLSPage ebay = new EbayTXTXLSPage();
    @Test(priority = 1)
    @Parameters({"browser"})
    public void verifyEbayTextbooksAllLinks(String browser) throws Exception {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get(ebay.ebayUrl);
        List<String> namestxt = new ArrayList<String>();
        List<String> ph = new ArrayList<String>();
        List<WebElement> names = driver.findElements(By.xpath(ebay.ebayTextbookNameLoc));//found all books names - all links
        List<WebElement> prices = driver.findElements(By.xpath(ebay.ebayTextbookPriceLoc));//found all books price - all links
        for (int i = 0; i < names.size(); ++i){
            namestxt.add(names.get(i).getText());
            ph.add(prices.get(i).getText());
        }
        //Create file xls format on DESKTOP
        String yelpfile = System.getProperty("user.home")+"/Desktop/ebayTitlePriceTextbooks.xls";
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Books");
        HSSFRow rowhead = sheet.createRow((short)0);
        rowhead.createCell(0).setCellValue("Title");
        rowhead.createCell(1).setCellValue("Rate");
        for (int i = 0; i < namestxt.size(); i++) {
            HSSFRow rows = sheet.createRow((short)i+1);
            rows.createCell(0).setCellValue(namestxt.get(i));
            rows.createCell(1).setCellValue(ph.get(i));
        }
        //print out to Desktop
        FileOutputStream fileOut = new FileOutputStream(yelpfile);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

    @Test(priority = 1)
    @Parameters({"browser"})
    public void verifyEbayTextbooksAllLinksLocalOnly(String browser) throws Exception {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get(ebay.ebayPickOnlyUrl);
        List<String> namestxt = new ArrayList<String>();
        List<String> ph = new ArrayList<String>();
        List<String> st = new ArrayList<String>();
        List<WebElement> names = driver.findElements(By.xpath(ebay.ebayTextbookNameLoc));//found all books names - all links
        List<WebElement> prices = driver.findElements(By.xpath(ebay.ebayTextbookPriceLoc));//found all books price - all links
        List<WebElement> secondtitle = driver.findElements(By.xpath(ebay.ebayTextbookSecInfoLoc));//found all books second title - all links
        for (int i = 0; i < names.size(); ++i){
            namestxt.add(names.get(i).getText());
            ph.add(prices.get(i).getText());
            st.add(secondtitle.get(i).getText());
        }
        System.out.println("namestxt" +namestxt.size()+"\n");
        System.out.println("ph" +ph.size()+"\n");
        System.out.println("sssssss" +st.size()+"\n");
        if(namestxt.size()>50){

        }




//        //Create file xls format on DESKTOP
//        String yelpfile = System.getProperty("user.home")+"/Desktop/ebayTitlePricePickOnlyTextbooks.xls";
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("Books");
//        HSSFSheet sheet2 = workbook.createSheet("ID");
//        HSSFSheet sheet3 = workbook.createSheet("Names");
//        HSSFSheet sheet4 = workbook.createSheet("Pages");
//        HSSFRow rowhead = sheet.createRow((short)0);
//        rowhead.createCell(0).setCellValue("Title");
//        rowhead.createCell(1).setCellValue("Second Title");
//        rowhead.createCell(2).setCellValue("Salary");
//        for (int i = 0; i < namestxt.size(); i++) {
//            HSSFRow rows = sheet.createRow((short)i+1);
//            rows.createCell(0).setCellValue(namestxt.get(i));
//            rows.createCell(1).setCellValue(st.get(i));
//            rows.createCell(2).setCellValue(ph.get(i));
//        }
//        //print out to Desktop
//        FileOutputStream fileOut = new FileOutputStream(yelpfile);
//        workbook.write(fileOut);
//        fileOut.close();
//        workbook.close();
    }
}
