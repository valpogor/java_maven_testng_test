package ui;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.openqa.selenium.interactions.Actions;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import static java.lang.Thread.sleep;

public class SeleniumFoxXlsCreated {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/SeleniumFoxXlsCreated/resources/chromedriver");
        String filename = System.getProperty("user.dir")+"/Desktop/fox.xls";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.fox.com/");
        driver.findElement(By.xpath("//*[contains(@href, 'shows')]")).click();
        Actions action = new Actions(driver);
        for(int i=0;i<5;i++)
        {
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            sleep(3000);
            action.release().perform();
        }
        List<WebElement> titles = driver.findElements(By.xpath("//*[contains(@class, 'Tile_details')]"));
        int size = titles.size();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Show");
        HSSFRow rowhead = sheet.createRow((short)0);
        rowhead.createCell(0).setCellValue("No.");
        rowhead.createCell(1).setCellValue("Show");
        HSSFRow row1 = sheet.createRow((short)1);
        HSSFRow row2 = sheet.createRow((short)2);
        HSSFRow row3 = sheet.createRow((short)3);
        HSSFRow row4 = sheet.createRow((short)4);
        row1.createCell(0).setCellValue("1");
        row2.createCell(0).setCellValue("2");
        row3.createCell(0).setCellValue("3");
        row4.createCell(0).setCellValue("4");
        row1.createCell(1).setCellValue(titles.get(size-4).getText());
        row2.createCell(1).setCellValue(titles.get(size-3).getText());
        row3.createCell(1).setCellValue(titles.get(size-2).getText());
        row4.createCell(1).setCellValue(titles.get(size-1).getText());
        // Fox
        driver.findElement(By.xpath("(//a[contains(.,'FX')])[2]")).click();
        sleep(2000);
        for(int i=0;i<5;i++)
        {
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            sleep(700);
            action.release().perform();
        }
        sleep(500);
        List<WebElement> fx = driver.findElements(By.xpath("//*[contains(@class, 'Tile_details')]"));
        int fxsize = fx.size();
        HSSFSheet sheetn = workbook.createSheet("FX");
        HSSFRow rowheadn = sheetn.createRow((short)0);
        rowheadn.createCell(0).setCellValue("No.");
        rowheadn.createCell(1).setCellValue("Show");
        HSSFRow row1n = sheetn.createRow((short)1);
        HSSFRow row2n = sheetn.createRow((short)2);
        HSSFRow row3n = sheetn.createRow((short)3);
        HSSFRow row4n = sheetn.createRow((short)4);
        row1n.createCell(0).setCellValue("1");
        row2n.createCell(0).setCellValue("2");
        row3n.createCell(0).setCellValue("3");
        row4n.createCell(0).setCellValue("4");
        row1n.createCell(1).setCellValue(fx.get(fxsize-4).getText());
        row2n.createCell(1).setCellValue(fx.get(fxsize-3).getText());
        row3n.createCell(1).setCellValue(fx.get(fxsize-2).getText());
        row4n.createCell(1).setCellValue(fx.get(fxsize-1).getText());
//        // FOX Sports
        driver.findElement(By.xpath("(//a[contains(.,'FOX Sports')])[1]")).click();
        sleep(2000);
        for(int i=0;i<5;i++)
        {
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            sleep(700);
            action.release().perform();
        }
        sleep(500);
        List<WebElement> sport = driver.findElements(By.xpath("//*[contains(@class, 'Tile_details')]"));
        int sportsize = sport.size();
        HSSFSheet sheetsport = workbook.createSheet("Fox Sports");
        HSSFRow rowheadsport = sheetsport.createRow((short)0);
        rowheadsport.createCell(0).setCellValue("No.");
        rowheadsport.createCell(1).setCellValue("Show");
        HSSFRow row1s = sheetsport.createRow((short)1);
        HSSFRow row2s = sheetsport.createRow((short)2);
        HSSFRow row3s = sheetsport.createRow((short)3);
        HSSFRow row4s = sheetsport.createRow((short)4);
        row1s.createCell(0).setCellValue("1");
        row2s.createCell(0).setCellValue("2");
        row3s.createCell(0).setCellValue("3");
        row4s.createCell(0).setCellValue("4");
        row1s.createCell(1).setCellValue(sport.get(sportsize-4).getText());
        row2s.createCell(1).setCellValue(sport.get(sportsize-3).getText());
        row3s.createCell(1).setCellValue(sport.get(sportsize-2).getText());
        row4s.createCell(1).setCellValue(sport.get(sportsize-1).getText());
        // All shows
        driver.findElement(By.xpath("(//a[contains(.,'All Shows')])[1]")).click();
        sleep(2000);
        for(int i=0;i<5;i++)
        {
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            sleep(700);
            action.release().perform();
        }
        sleep(500);
        List<WebElement> all = driver.findElements(By.xpath("//*[contains(@class, 'Tile_details')]"));
        int allsize = all.size();
        HSSFSheet sheetall = workbook.createSheet("ALL");
        HSSFRow rowheadall = sheetall.createRow((short)0);
        rowheadall.createCell(0).setCellValue("No.");
        rowheadall.createCell(1).setCellValue("Show");
        HSSFRow row1a = sheetall.createRow((short)1);
        HSSFRow row2a = sheetall.createRow((short)2);
        HSSFRow row3a = sheetall.createRow((short)3);
        HSSFRow row4a = sheetall.createRow((short)4);
        row1a.createCell(0).setCellValue("1");
        row2a.createCell(0).setCellValue("2");
        row3a.createCell(0).setCellValue("3");
        row4a.createCell(0).setCellValue("4");
        row1a.createCell(1).setCellValue(all.get(allsize-4).getText());
        row2a.createCell(1).setCellValue(all.get(allsize-3).getText());
        row3a.createCell(1).setCellValue(all.get(allsize-2).getText());
        row4a.createCell(1).setCellValue(all.get(allsize-1).getText());
// National
        driver.findElement(By.xpath("(//a[contains(.,'National Geo')])[2]")).click();
        sleep(2000);
        for(int i=0;i<5;i++)
        {
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            sleep(700);
            action.release().perform();
        }
        sleep(500);
        List<WebElement> nat = driver.findElements(By.xpath("//*[contains(@class, 'Tile_details')]"));
        int natsize = nat.size();
        HSSFSheet sheetnat = workbook.createSheet("NATIONAL GEO");
        HSSFRow rownat = sheetnat.createRow((short)0);
        rownat.createCell(0).setCellValue("No.");
        rownat.createCell(1).setCellValue("Show");
        HSSFRow row1nat = sheetnat.createRow((short)1);
        HSSFRow row2nat = sheetnat.createRow((short)2);
        HSSFRow row3nat = sheetnat.createRow((short)3);
        HSSFRow row4nat = sheetnat.createRow((short)4);
        row1nat.createCell(0).setCellValue("1");
        row2nat.createCell(0).setCellValue("2");
        row3nat.createCell(0).setCellValue("3");
        row4nat.createCell(0).setCellValue("4");
        row1nat.createCell(1).setCellValue(nat.get(natsize-4).getText());
        row2nat.createCell(1).setCellValue(nat.get(natsize-3).getText());
        row3nat.createCell(1).setCellValue(nat.get(natsize-2).getText());
        row4nat.createCell(1).setCellValue(nat.get(natsize-1).getText());
        // Create xls output file
        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        driver.quit();
    }
}

