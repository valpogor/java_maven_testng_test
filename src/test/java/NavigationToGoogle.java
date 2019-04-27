import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class NavigationToGoogle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver");
        WebDriver drChrome = new ChromeDriver();
        drChrome.get("http://www.google.com");// open browser , navigate to google.com
        WebElement el = drChrome.findElement(By.name("q")); //found field inside DOM by name
        el.sendKeys("QA Job Market ");//send some text to field Google Search
        el.submit();

        if( drChrome.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a")).isDisplayed()){ //assert
            System.out.print("Element found");
        }
        else{
            System.out.print("Element not found");
        }
        drChrome.close();
        }
    }
