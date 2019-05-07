package ui;

import common.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import web.driver.factory.DriverFactory;

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
    public void VerifyVPStartBtnOnYoutube(String browser) throws Exception{
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://www.datafaction.com/resources.html");
        Thread.sleep(3000);// waiter 1 sec
        driver.findElement(By.xpath("//*[@id=\"w-vulcan-v2-193\"]/div[2]/div[2]/div/div[1]/div")).click();//click on button blog
        Thread.sleep(200000);// waiter 20 sec
    }
}
