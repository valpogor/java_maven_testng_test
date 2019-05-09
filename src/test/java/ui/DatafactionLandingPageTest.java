package ui;

import common.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pages.*;
import web.driver.factory.DriverFactory;

import java.io.FileOutputStream;
import java.util.*;

public class DatafactionLandingPageTest extends LoginPage {

    //AUT-1086 Verify solution button on datafaction.com
    @Test
    @Parameters({"browser"})
    public void VerifySolutionBtnDataf(String browser) throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://datafaction.com");
        Utility.waitForTitleIs(driver, "Datafaction Specialized Accounting Solutions", 10);
        driver.findElement(By.xpath("//*[@id='cnb-navbar-collapse']/ul/li[2]/a")).click();
        Utility.waitForTitleIs(driver, "Accounting Software Solutions | AgilLink by Datafaction", 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("/solutions.html"));//1 verification
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='text parbase']//b")).getText().contains("DATAFACTION IS A COMPREHENSIVE ACCOUNTING SOLUTION"));//2 verification
        Assert.assertTrue(driver.findElements(By.xpath("//*[@class='text parbase']")).size()==1);//3 verification
    }

    //AUT-1087 Verify BLOG button on datafaction.com
    @Test
    @Parameters({"browser"})
    public void VerifyBlogBtnDataf(String browser) throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://datafaction.com");//navigation to url
        driver.findElement(By.xpath("//*[@id=\"cnb-navbar-collapse\"]/ul/li[3]/a")).click();//click on button blog
//        Thread.sleep(1000);// waiter 1 sec
        Utility.waitForElementVisible(driver, By.xpath("//*[@id=\"main\"]/div[1]/span/div/a"), 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("/blog.html"));//1 verification
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/span/div/a")).isDisplayed());//2 verification
        Assert.assertTrue(driver.findElements(By.xpath("//*[@class='df-common-blogcard-link']")).size()==2);//3 verification
    }

    //AUT-1173 Verify videoplayer start button on Datafaction
    @Test
    @Parameters({"browser"})
    public void VerifyVPStartBtnOnDatafaction(String browser) throws Exception{
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://www.datafaction.com/resources.html");
        Thread.sleep(3000);// waiter 1 sec
        driver.findElement(By.xpath("//*[@id=\"w-vulcan-v2-193\"]/div[2]/div[2]/div/div[1]/div")).click();//click on button blog
        Utility.waitForElementDisappear(driver,By.xpath("//*[@id='w-vulcan-v2-122']/div[3]/div[1]/div/div[@aria-valuetext='0:00']"),10);
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='w-vulcan-v2-122']/div[3]/div[1]/div/div[@aria-valuetext='0:00']")).isDisplayed());
    }

    //AUT-1174 Verify videoplayer start button on Youtube
    @Test
    @Parameters({"browser"})
    public void VerifyVPStartBtnOnYoutube(String browser) throws Exception{
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//*[@id='dismissable'])[2]")).click();//click on button blog
        Thread.sleep(5000);// waiter 20 sec
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/watch"));
        Assert.assertFalse(driver.getTitle().matches("youtube"));
    }

    //AUT-2011 Verify ability to login Gmail account
    @Test
    @Parameters({"browser"})
    public void VerifyAbilityLoginGmailAcc(String browser){
        Utility.loginToGmail(browser);
    }

    //AUT-2012 Verify ability to login Gmail account with specific account
//    @Test
    @Parameters({"browser"})
    public void VerifyAbilityLoginGmailAccByUser(String browser){
        Utility.loginToGmailByUser(browser, "vova@gmail.com", "hvkjvkjvlkblkblkbn,");
    }

    //AUT-2013 Verify ability to login Gmail account with invalid user login credentials
    @Test
    @Parameters({"browser"})
    public void VerifyAbilityLoginGmailAccInvalid(String browser) {
        Utility.loginToGmailNegat(browser, ".");
    }

    //AUT-2013 Verify ability to login Gmail account with invalid user login credentials
    @Test
    @Parameters({"browser"})
    public void VerifyAbilityLoginGmailAccInvalid1(String browser) {
        Utility.loginToGmailNegat(browser, "fgxhgchgjc@@gmail.com");
    }

    //AUT-2013 Verify ability to login Gmail account with invalid user login credentials
    @Test
    @Parameters({"browser"})
    public void VerifyAbilityLoginGmailAccInvalid2(String browser) {
        Utility.loginToGmailNegat(browser, "@gmail.com");
    }
}
