package ui;//package ui;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.Test;
//import pages.LoginPage;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class SeleniumGrid2 extends LoginPage {
//    @Test
//    public void mailTest() throws MalformedURLException {
//        DesiredCapabilities dr=null;
//        dr=DesiredCapabilities.firefox();
//        dr.setBrowserName("firefox");
//        dr.setPlatform(Platform.MAC);
//
//        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), dr);
//        driver.navigate().to("http://gmail.com");
//        driver.findElement(By.xpath("//input[@id='Email']")) .sendKeys("username");
//        driver.findElement(By.xpath("//input[@id='Passwd']")) .sendKeys("password");
//        driver.close();
//    }
//}
