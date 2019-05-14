package ui;

import common.Utility;
import org.apache.spark.sql.execution.columnar.NULL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import web.driver.factory.DriverFactory;

import java.util.*;

public class DatafactionLinksLoopsTest extends LoginPage {
    @Test
    @Parameters({"browser"})
    public void DatafactionFindAllLinks(String browser) throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://datafaction.com");
        String[] links = null;
        int linksCount = 0;
        List<WebElement> linksize = driver.findElements(By.tagName("a"));//found all tags a - all links
        linksCount = linksize.size();
        System.out.println("Total no of links Available: " + linksCount);
        links = new String[linksCount];
 //print all links from webpage
        for (int i = 0; i < linksCount; i++) {
            List<WebElement> all_links_webpage = driver.findElements(By.tagName("a"));
            links[i] = linksize.get(i).getAttribute("href");
            System.out.println(all_links_webpage.get(i).getAttribute("href"));
        }
    }

    @Test
    @Parameters({"browser"})
    public void DatafactionNavigateToAllLinks(String browser) throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://datafaction.com");
        String[] links = null;
        int linksCount = 0;
        List<WebElement> linksize = driver.findElements(By.tagName("a"));//found all tags a - all links
        List<String> urls = new ArrayList<>();
        //found all tags a - all links
        linksCount = linksize.size();
        System.out.println("Total no of links Available: " + linksCount);
        links = new String[linksCount];
// print all the links from webpage
        for (int i = 0; i < linksCount; i++) {
            List<WebElement> all_links_webpage = driver.findElements(By.tagName("a"));
            links[i] = linksize.get(i).getAttribute("href");
            urls.add(all_links_webpage.get(i).getAttribute("href"));
        }
//Delete duplicates
        Set<String> set = new HashSet<>(urls);
        urls.clear();
        urls.addAll(set);
        System.out.println("Total no of links Available after : " + urls.size());
// navigate to each Link on the webpage
        for (int i = 0; i < urls.size(); i++) {
            driver.navigate().to(urls.get(i));//navigation
            String curl = driver.getCurrentUrl();
            System.out.println(curl);
            if (curl.contains(urls.get(i))) {//https://www.datafaction.com/resources.html
                System.out.println("True");
                assert true;
            } else {
                System.out.println("False");
                assert false;
            }
        }
    }

//    @Test
//    @Parameters({"browser"})
//    public void DatafactionPrintNameAllLinks(String browser) throws InterruptedException {
//        WebDriver driver = DriverFactory.getDriver(browser);
//        driver.get("https://datafaction.com");
//        List<WebElement> linksize = driver.findElements(By.tagName("a"));//found all tags a - all links
//        Iterator<WebElement> itr = linksize.iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next().getText());
//        }
//    }

}
