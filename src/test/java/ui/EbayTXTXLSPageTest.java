package ui;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import pages.EbayTXTXLSPage;
import web.driver.factory.DriverFactory;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EbayTXTXLSPageTest extends EbayTXTXLSPage {

    @Test(priority = 1)
    @Parameters({"browser"})
    public void verifyEbayTextbooksAllLinks(String browser) throws Exception {
        EbayTXTXLSPage ebay = new EbayTXTXLSPage();
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get(ebay.ebayUrl);
        List<String> namestxt = new ArrayList<String>();
        List<String> ph = new ArrayList<String>();
        List<WebElement> names = driver.findElements(By.xpath(ebay.ebayTextbookNameLoc));//found all tags a - all links
        List<WebElement> prices = driver.findElements(By.xpath(ebay.ebayTextbookPriceLoc));//found all tags a - all links
        for (int i = 0; i < names.size(); ++i){
            namestxt.add(names.get(i).getText());
            ph.add(prices.get(i).getText());
        }
        String yelpfile = System.getProperty("user.home")+"/Desktop/ebayTextbooks.xls";
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("TextBooks");
        HSSFRow rowhead = sheet.createRow((short)0);
        rowhead.createCell(0).setCellValue("Book");
        rowhead.createCell(1).setCellValue("Price");
        for (int i = 0; i < namestxt.size(); i++) {
            HSSFRow rows = sheet.createRow((short)i+1);
            rows.createCell(0).setCellValue(namestxt.get(i));
            rows.createCell(1).setCellValue(ph.get(i));
        }
        FileOutputStream fileOut = new FileOutputStream(yelpfile);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}
