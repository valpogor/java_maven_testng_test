package ui;

import common.*;
import org.apache.poi.hssf.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import web.driver.factory.DriverFactory;
import java.io.*;
import java.util.*;

public class YelpFindAllNamesPhones extends LoginPage {

    @Test
    @Parameters({"browser"})
    public void yelpSearchSelenium(String browser)throws Exception{
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://www.yelp.com/search?find_desc=concreate&find_loc=Van+Nuys%2C+Los+Angeles%2C+CA&ns=1");
        ArrayList<String> comp = Utility.collecElementTxt(driver, "//*[@class='lemon--div__373c0__1mboc businessName__373c0__1fTgn border-color--default__373c0__2oFDT']");
        ArrayList<String> ph = Utility.collecElementTxt(driver, "//*[@class='lemon--div__373c0__1mboc display--inline-block__373c0__2de_K u-space-b1 border-color--default__373c0__2oFDT']");
        String yelpfile = System.getProperty("user.home")+"/Desktop/yelp.xls";
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Van Nuys");
        HSSFRow rowhead = sheet.createRow((short)0);
        rowhead.createCell(0).setCellValue("Companies");
        rowhead.createCell(1).setCellValue("Phones");
        for (int i = 0; i < comp.size(); i++) {
            HSSFRow rows = sheet.createRow((short)i+1);
            rows.createCell(0).setCellValue(comp.get(i));
            rows.createCell(1).setCellValue(ph.get(i));
        }
        FileOutputStream fileOut = new FileOutputStream(yelpfile);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        Utility.deleteFileOnDesktop(new File(yelpfile));
    }

}
