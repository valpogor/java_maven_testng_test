//package ui;//package ui;
////
//import org.openqa.selenium.*;
//import org.openqa.selenium.remote.*;
//import org.openqa.selenium.support.ui.*;
//import org.testng.annotations.*;
//import pages.LoginPage;
//
//import java.net.*;
//import java.text.*;
//import java.util.*;
//
//public class SeleniumGrid extends LoginPage {
//    @Test
//    public void executeFirefoxDriver() throws MalformedURLException, Exception {
//        this.execute(DesiredCapabilities.firefox());
//    }
//
//    @Test
//    public void executeChrome() throws MalformedURLException, Exception {
//        this.execute(DesiredCapabilities.chrome());
//    }
//
//    private void execute(final DesiredCapabilities capability) throws MalformedURLException, Exception {
//
////        WebDriver driver = new RemoteWebDriver(
////                new URL("http://localhost:4444/wd/hub"), capability
////        );
////
////        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
////        capability.setCapability("enableVNC", true);
////        capability.setCapability("enableVideo", false);
////        String browserName = cap.getBrowserName().toLowerCase();
////        System.out.println(browserName);
////        String os = cap.getPlatform().toString();
////        System.out.println(os);
////        String v = cap.getVersion().toString();
////        System.out.println(v);
////        driver.get("http://www.google.com/");
////        driver.findElement(By.name("q")).sendKeys("webdriver");
////        driver.findElement(By.name("btnK")).click();
////        Thread.sleep(10000);
////        WebElement element = driver.findElement(By.name("s"));
////        element.sendKeys("selenuim");
////        element.submit();
////        driver.quit();
//    }
//
////    private static WebDriver driver;
////
////    public static WebDriver getChromeDriver() throws Exception {
////        DesiredCapabilities capabilities =  DesiredCapabilities.chrome();
////        WebDriver driver = new RemoteWebDriver(
////                new URL("http://0.0.0.0:4444/wd/hub"),
////                capabilities);
////        return driver;
////
////
////    }
////
////    @AfterSuite
////    public static void AfterSuite(){
////    }
////
////    @BeforeTest
////    public void setUp() {
////        driver.manage().window().maximize();
////        driver.get("http://www.yahoo.com");
////    }
//
//    @Test
//    public void GoogleTest() throws Exception{
//        WebElement element = driver.findElement(By.name("q"));
//        element.sendKeys("Global Butlers");
//        element.submit();
//        ExpectedConditions.visibilityOf((WebElement) By.xpath("//*[@class='Global Butlers']"));
//        Thread.sleep(100000);
//    }
//}
////
