package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.findElement(By.xpath("//*[@id=\"cnb-navbar-collapse\"]/ul/li[2]/a")).click();
        Thread.sleep(1000);
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
        Thread.sleep(1000);// waiter 1 sec
        Assert.assertTrue(driver.getCurrentUrl().contains("/blog.html"));//1 verification
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/span/div/a")).isDisplayed());//2 verification
        Assert.assertTrue(driver.findElements(By.xpath("//*[@class='df-common-blogcard-link']")).size()==2);//3 verification
    }
}
