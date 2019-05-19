package ui;

import common.*;
import org.apache.poi.hssf.usermodel.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pages.*;
import web.driver.factory.DriverFactory;
import java.io.*;
import java.util.*;

public class NavigationToGoogle extends LoginPage{
    @Test
    @Parameters({"browser"})
    public static void searchGoogle(String browser) {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("http://www.google.com");// open browser , navigate to google.com
        WebElement el = driver.findElement(By.name("q")); //found field inside DOM by name
        el.sendKeys("QA Job Market ");//send some text to field Google Search
        el.submit();
        if( driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a")).isDisplayed()){ //assert
            System.out.print("Element found");
        }
        else{
            System.out.print("Element not found");
        }
        }

        @Test
        @Parameters({"browser"})
        public static void searchAol(String browser) throws InterruptedException {
        LoginPage log = new LoginPage();
            WebDriver driver = DriverFactory.getDriver(browser);
            driver.get("http://www.aol.com");// open browser , navigate to google.com
            WebElement el = driver.findElement(By.name("q")); //found field inside DOM by name
            el.sendKeys("QA Job Market ");//send some text to field  Search
            el.submit();
            Thread.sleep(3000);
            Assert.assertTrue(driver.findElements(By.partialLinkText("Video")).size()>1);
        }

        @Test
        @Parameters({"browser"})
        public static void searchYahoo(String browser) {
            WebDriver driver = DriverFactory.getDriver(browser);
            driver.get("http://www.yahoo.com");// open browser , navigate to google.com
            WebElement el = driver.findElement(By.xpath("//span[contains(text(), 'Search')]")); //found field inside DOM by name
            el.sendKeys("QA Job Market");//send some text to field Google Search
            el.submit();
            Assert.assertTrue(driver.findElements(By.partialLinkText("QA Job Market")).size()>1);
        }
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
    }

    @Test(priority = 1)
    @Parameters({"browser"})
    public void verifyDatafactionPageAllLinks(String browser) throws Exception {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://datafaction.com");
        String[] links = null;
        int linksCount = 0;
        List<WebElement> linksize = driver.findElements(By.tagName("a"));//found all tags a - all links
        linksCount = linksize.size();
        System.out.println("Total no of links Available: " + linksCount);
        links = new String[linksCount];
// print all the links from webpage
        for (int i = 0; i < linksCount; i++) {
            List<WebElement> all_links_webpage = driver.findElements(By.tagName("a"));
            links[i] = linksize.get(i).getAttribute("href");
            System.out.println(all_links_webpage.get(i).getAttribute("href"));
        }

// navigate to each Link on the webpage
        for (int i = 0; i < linksCount; i++) {
            driver.navigate().to(links[i]);//navigation
            String curl = driver.getCurrentUrl();
            System.out.println(curl);
            if (curl.contains(links[i])) {//https://www.datafaction.com/resources.html
                System.out.println("True");
                assert true;
            } else {
                System.out.println("False");
                assert false;
            }
        }
    }
    }
