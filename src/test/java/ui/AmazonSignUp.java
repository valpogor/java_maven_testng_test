package ui;

import common.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.remote.*;
import org.testng.*;
import org.testng.annotations.*;
import pages.*;
import web.driver.factory.DriverFactory;
import javax.mail.*;
import java.util.*;
import java.util.regex.*;

public class AmazonSignUp extends LoginPage {
    @Test()
    @Parameters({"browser"})
    public void amazonSignUp(String browser){
        WebDriver d = DriverFactory.getDriver(browser);
        d.get("http://www.amazon.com/");
        Actions mouse = new Actions(d);
        WebElement signIn = d.findElement(By.id("nav-link-accountList"));
        mouse.moveToElement(signIn).build().perform();
        d.findElement(By.className("nav-a")).click();
        d.findElement(By.name("customerName")).sendKeys("Bob Marlin");
        d.findElement(By.name("email")).sendKeys("your_email");
        d.findElement(By.name("password")).sendKeys("BobMarlin!.");
        d.findElement(By.name("passwordCheck")).sendKeys("BobMarlin!.");
        d.findElement(By.id("continue")).click();
        AssertJUnit.assertTrue(d.getTitle().contains("Authentication required"));
        d.findElement(By.name("code")).sendKeys(readingEmailReturnCodeFromGmail(
                "(?<=otp\">)(.*)(?=<)", "your_email", "your pwd"));
        d.findElement(By.xpath("//input[@aria-labelledby='a-autoid-0-announce']")).click();
    }

// Method to read first email and return code, for amazon sighup and mail settings for gmail service
    public static String readingEmailReturnCodeFromGmail(String regex, String email, String password){
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        String code = "";
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", email, password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount());
            Multipart mp = (Multipart) msg.getContent();
            BodyPart bp = mp.getBodyPart(0);
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(bp.getContent().toString());
            while (m.find()){
                System.out.println("CODE:" + m.group(1));
                code = m.group(1);
                return code;
            }
        } catch (Exception mex) {
            mex.printStackTrace();
        }
        return code;
    }

    @Test()
    @Parameters({"browser"})
    public void amazonNavTop(String browser) throws Exception{
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://www.amazon.com");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"navBackToTop\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        driver.findElement(By.xpath("//*[@id=\"navBackToTop\"]/div/span")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("#nav-top"));
    }

    @Test()
    @Parameters({"browser"})
    public void amazonNavigationWhole(String browser) throws Exception{
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[5]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("whole"));
    }

    @Test()
    @Parameters({"browser"})
    public void amazonNavigation(String browser) throws Exception{
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[5]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("whole"));
    }

    @Test()
    @Parameters({"browser"})
    public void cnetSignUp(String browser) throws Exception{
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://www.cnet.com");
        Actions act = new Actions(driver);
        WebElement el = driver.findElement(By.xpath("//div[@class='button button_type_reversed-secondary button_size_small ']/span"));
        act.moveToElement(el).perform();
        act.click().doubleClick().build().perform();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.findElement(By.xpath("//button[@data-action='urs']/span")).click();
        driver.findElement(By.xpath("//input[@type='email' and @aria-invalid='true']")).click();
        driver.findElement(By.xpath("//input[@type='email' and @aria-invalid='true']")).sendKeys("youremail@gmail.com");
        driver.findElement(By.xpath("//div[@class='_loginOrRegister active']//span[text()[.='Continue']]")).click();
        }
}