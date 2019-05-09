import common.Utility;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import web.driver.factory.DriverFactory;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

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
        driver.close();
        }

//        @Test
//    public static void searchAol() throws InterruptedException {
//        LoginPage log = new LoginPage();
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver");
//        WebDriver drChrome = new ChromeDriver();
//        drChrome.get("http://www.aol.com");// open browser , navigate to google.com
//        WebElement el = drChrome.findElement(By.name("q")); //found field inside DOM by name
//        el.sendKeys("QA Job Market ");//send some text to field Google Search
//        el.submit();
//        Thread.sleep(3000);
//        Assert.assertTrue(drChrome.findElement(By.id(log.aolVideoBtnLoc)).isDisplayed());
//        Assert.assertTrue(drChrome.findElements(By.partialLinkText("Video")).size()>1);
//
//        }
//
//        @Test
//    public static void searchYahoo() {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
//        WebDriver drChrome = new ChromeDriver();
//        drChrome.get("http://www.yahoo.com");// open browser , navigate to google.com
//        WebElement el = drChrome.findElement(By.name("q")); //found field inside DOM by name
//        el.sendKeys("QA Job Market ");//send some text to field Google Search
//        el.submit();
////
////        if( drChrome.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a")).isDisplayed()){ //assert
////            System.out.print("Element found");
////        }
////        else{
////            System.out.print("Element not found");
////        }
////        drChrome.close();
//    }
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
//        Set<String> set = new HashSet<>(links);
//        all_links_webpage.clear();
//        all_links_webpage.addAll(set);
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
