import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import web.driver.factory.DriverFactory;

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

    }
