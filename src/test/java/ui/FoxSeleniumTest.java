// Using library selenium for web parsing(find some elements) and writing to xls file, also using scroll down

package ui;
import common.Utility;
import org.openqa.selenium.*;
import org.apache.poi.hssf.usermodel.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.*;
import pages.LoginPage;
import web.driver.factory.DriverFactory;

import java.io.*;
import java.util.*;
import static java.lang.Thread.*;

public class FoxSeleniumTest extends LoginPage {
//    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
//        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
//    }

    @Test
    @Parameters({"browser"})
    public void foxtest(String browser) throws InterruptedException, IOException {
        WebDriver driver = DriverFactory.getDriver(browser);
        String filename = System.getProperty("user.home")+"/Desktop/foxselenium.xls";
        driver.get("https://www.fox.com/");
        driver.findElement(By.xpath("(//*[contains(@href, 'sports')])[1]")).click();

        Actions action = new Actions(driver);
        for(int i=0;i<5;i++)
        {
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(3000);
            action.release().perform();
        }
        List<WebElement> titles = driver.findElements(By.xpath(foxPageLoc));
        int size = titles.size();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Show");
        HSSFRow rowhead = sheet.createRow((short)0);
        rowhead.createCell(0).setCellValue("No.");
        rowhead.createCell(1).setCellValue("Show");
        HSSFRow row1 = sheet.createRow((short)1);
        HSSFRow row2 = sheet.createRow((short)2);
        HSSFRow row3 = sheet.createRow((short)3);
        HSSFRow row4 = sheet.createRow((short)4);
        row1.createCell(0).setCellValue("1");
        row2.createCell(0).setCellValue("2");
        row3.createCell(0).setCellValue("3");
        row4.createCell(0).setCellValue("4");
        row1.createCell(1).setCellValue(titles.get(size-4).getText());
        row2.createCell(1).setCellValue(titles.get(size-3).getText());
        row3.createCell(1).setCellValue(titles.get(size-2).getText());
        row4.createCell(1).setCellValue(titles.get(size-1).getText());
// Home
        driver.findElement(By.xpath(foxPageHomeLoc)).click();
        sleep(2000);
        for(int i=0;i<5;i++)
        {
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(700);
            action.release().perform();
        }
        Thread.sleep(500);
        List<WebElement> fx = driver.findElements(By.xpath(foxPageLoc));
        int fxsize = fx.size();
        HSSFSheet sheetn = workbook.createSheet("FX");
        HSSFRow rowheadn = sheetn.createRow((short)0);
        rowheadn.createCell(0).setCellValue("No.");
        rowheadn.createCell(1).setCellValue("Show");
        HSSFRow row1n = sheetn.createRow((short)1);
        HSSFRow row2n = sheetn.createRow((short)2);
        HSSFRow row3n = sheetn.createRow((short)3);
        HSSFRow row4n = sheetn.createRow((short)4);
        row1n.createCell(0).setCellValue("1");
        row2n.createCell(0).setCellValue("2");
        row3n.createCell(0).setCellValue("3");
        row4n.createCell(0).setCellValue("4");
        row1n.createCell(1).setCellValue(fx.get(fxsize-4).getText());
        row2n.createCell(1).setCellValue(fx.get(fxsize-3).getText());
        row3n.createCell(1).setCellValue(fx.get(fxsize-2).getText());
        row4n.createCell(1).setCellValue(fx.get(fxsize-1).getText());
// Shows
        driver.findElement(By.xpath("//a[contains(text(), 'Sports')]")).click();
        sleep(2000);
        for(int i=0;i<5;i++)
        {
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(700);
            action.release().perform();
        }
        Thread.sleep(500);
        List<WebElement> sport = driver.findElements(By.xpath(foxPageLoc));
        int sportsize = sport.size();
        HSSFSheet sheetsport = workbook.createSheet("Fox Sports");
        HSSFRow rowheadsport = sheetsport.createRow((short)0);
        rowheadsport.createCell(0).setCellValue("No.");
        rowheadsport.createCell(1).setCellValue("Show");
        HSSFRow row1s = sheetsport.createRow((short)1);
        HSSFRow row2s = sheetsport.createRow((short)2);
        HSSFRow row3s = sheetsport.createRow((short)3);
        HSSFRow row4s = sheetsport.createRow((short)4);
        row1s.createCell(0).setCellValue("1");
        row2s.createCell(0).setCellValue("2");
        row3s.createCell(0).setCellValue("3");
        row4s.createCell(0).setCellValue("4");
        row1s.createCell(1).setCellValue(sport.get(sportsize-4).getText());
        row2s.createCell(1).setCellValue(sport.get(sportsize-3).getText());
        row3s.createCell(1).setCellValue(sport.get(sportsize-2).getText());
        row4s.createCell(1).setCellValue(sport.get(sportsize-1).getText());
// Sports
        driver.findElement(By.xpath("//a[contains(text(), 'Sports')]")).click();
        sleep(2000);
        for(int i=0;i<5;i++)
        {
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(700);
            action.release().perform();
        }
        Thread.sleep(500);
        List<WebElement> all = driver.findElements(By.xpath(foxPageLoc));
        int allsize = all.size();
        HSSFSheet sheetall = workbook.createSheet("ALL");
        HSSFRow rowheadall = sheetall.createRow((short)0);
        rowheadall.createCell(0).setCellValue("No.");
        rowheadall.createCell(1).setCellValue("Show");
        HSSFRow row1a = sheetall.createRow((short)1);
        HSSFRow row2a = sheetall.createRow((short)2);
        HSSFRow row3a = sheetall.createRow((short)3);
        HSSFRow row4a = sheetall.createRow((short)4);
        row1a.createCell(0).setCellValue("1");
        row2a.createCell(0).setCellValue("2");
        row3a.createCell(0).setCellValue("3");
        row4a.createCell(0).setCellValue("4");
        row1a.createCell(1).setCellValue(all.get(allsize-4).getText());
        row2a.createCell(1).setCellValue(all.get(allsize-3).getText());
        row3a.createCell(1).setCellValue(all.get(allsize-2).getText());
        row4a.createCell(1).setCellValue(all.get(allsize-1).getText());
        // Create xls output file
        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        Utility.deleteFileOnDesktop(new File("foxselenium.xls"));
    }
}