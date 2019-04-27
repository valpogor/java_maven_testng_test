import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

public class LoginPage {

    public WebDriver driver;
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";

    @BeforeSuite
    public void BeforeSuite() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver");
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("marionette", true);
        caps.setCapability("networkConnectionEnabled", true);
        caps.setCapability("browserConnectionEnabled", true);
        caps.setCapability("disable-web-security", true);
        caps.setJavascriptEnabled(true);
        driver = new FirefoxDriver(caps);
    }

    @BeforeTest
    public void setUp() {
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }


    @Test()
    public void GoogleTest1() throws Exception{
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='LC20lb'])[1]")).getText().contains("Selenium WebDriver"));
        System.out.print("Element: " + driver.findElement(By.xpath("(//*[@class='LC20lb'])[1]")).getText() + " displayed\n");
        System.out.print(ANSI_GREEN_BACKGROUND + "SUCCESS! " + ANSI_RESET);
    }

    @Test
    public void GoogleTest2() throws Exception{
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("monster jobs");
        driver.findElement(By.xpath("(//*[@type='submit'])[3]")).click();
        if(driver.findElement(By.xpath("//*[contains(text(), 'Searches related to monster jobs')]")).isDisplayed()){
            assert true;
            System.out.print(ANSI_GREEN_BACKGROUND + "SUCCESS! " + ANSI_RESET);
        }
        else
        {assert false;}
    }
    @Test
    public void GoogleTest3() throws Exception{
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("stackoverflow");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='LC20lb'])[1]")).isDisplayed());
        System.out.print(ANSI_GREEN_BACKGROUND + "SUCCESS! " + ANSI_RESET);

    }

    //DD-2185Verify submit button in landing page
    @Test
    public void VerifySubBtnInLandingPage() {
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("stackoverflow");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='LC20lb'])[1]")).isDisplayed());
        System.out.print(ANSI_GREEN_BACKGROUND + "SUCCESS! " + ANSI_RESET);
    }

    @Test
    public void VerifyDropDownEbayHalf() throws InterruptedException {
        driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");	//enter url
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByVisibleText("California");
        System.out.print(ANSI_GREEN_BACKGROUND + "SUCCESS! " + ANSI_RESET);
    }


}

