package unit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class YelpFindAllNamesPhones extends LoginPage {

    @Test
    public void yelpSearchJsoup()throws Exception{
        String urlshows = "https://www.yelp.com/search?find_desc=concreate&find_loc=Van+Nuys%2C+Los+Angeles%2C+CA&ns=1";
        Document shows = Jsoup.connect(urlshows).get();
        Elements comps = shows.select("div[class*='lemon--div__373c0__1mboc businessName__373c0__1fTgn border-color--default__373c0__2oFDT']");
        Elements phs = shows.select("div[class*='lemon--div__373c0__1mboc display--inline-block__373c0__2de_K u-space-b1 border-color--default__373c0__2oFDT']");
        List<String> comp = new ArrayList<String>();
        List<String> ph = new ArrayList<String>();
        for (int i = 0; i < comps.size(); ++i){
            comp.add(comps.get(i).text());
            ph.add(phs.get(i).text());}
        String yelpfile = System.getProperty("user.home")+"/Desktop/yelpJsoup.xls";
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Van Nuys");
        HSSFRow rowhead = sheet.createRow((short)0);
        rowhead.createCell(0).setCellValue("Companies");
        rowhead.createCell(1).setCellValue("Phones");
        for (int i = 0; i < comp.size(); i++) {
            HSSFRow rows = sheet.createRow((short)i+1);
            rows.createCell(0).setCellValue(comp.get(i));
            rows.createCell(1).setCellValue(ph.get(i));
        }
        FileOutputStream fileOut = new FileOutputStream(yelpfile);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

}
