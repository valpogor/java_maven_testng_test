// Using library jsoup for web parsing(find some elements) and writing to xls file

package unit;
import common.Utility;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.apache.poi.hssf.usermodel.*;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.*;
import java.util.*;

public class FoxJsoupTest extends LoginPage {
//    public static void main(String[] args) throws IOException {
    @Test
    public void FoxJsoupTest()throws IOException{
        String filename = System.getProperty("user.home")+"/Desktop/foxjsoup.xls";
        String xpath = "div[class*='Tile_details']";
        List<String> shows_l = new ArrayList<String>();
        List<String> fx_l = new ArrayList<String>();
        List<String> nat_l = new ArrayList<String>();
        List<String> sport_l = new ArrayList<String>();
        List<String> all_l = new ArrayList<String>();
        String urlshows = "https://www.fox.com/";
        Document shows = Jsoup.connect(urlshows).get();
        Elements shows_ = shows.select(xpath);
        int shows_size = shows_.size();
        for (int i = 0; i < shows_size; ++i)
            shows_l.add(shows_.get(i).text());
        String urlfx = "https://www.fox.com/sports/";
        Document fx = Jsoup.connect(urlfx).get();
        Elements fx_ = fx.select(xpath);
        int fx_size = fx_.size();
        for (int i = 0; i < fx_size; ++i)
            fx_l.add(fx_.get(i).text());
        String urlnat = "https://www.fox.com/sports/";
        Document nat = Jsoup.connect(urlnat).get();
        Elements nat_ = nat.select(xpath);
        int nat_size = nat_.size();
        for (int i = 0; i < nat_size; ++i)
            nat_l.add(nat_.get(i).text());
        String urlsport = "https://www.fox.com/sports/";
        Document sport = Jsoup.connect(urlsport).get();
        Elements sport_ = sport.select(xpath);
        int sport_size = sport_.size();
        for (int i = 0; i < sport_size; ++i)
            sport_l.add(sport_.get(i).text());
        String urlall = "https://www.fox.com/live/";
        Document all = Jsoup.connect(urlall).get();
        Elements all_ = all.select(xpath);
        int all_size = all_.size();
        for (int i = 0; i < all_size; ++i)
            all_l.add(all_.get(i).text());
        HSSFWorkbook workbook = new HSSFWorkbook();
//        // All shows
        HSSFSheet sheetall = workbook.createSheet("Shows");
        HSSFRow rowheadall = sheetall.createRow((short) 0);
        rowheadall.createCell(0).setCellValue("No.");
        rowheadall.createCell(1).setCellValue("Show");
        HSSFRow row1a = sheetall.createRow((short) 1);
        HSSFRow row2a = sheetall.createRow((short) 2);
        HSSFRow row3a = sheetall.createRow((short) 3);
        HSSFRow row4a = sheetall.createRow((short) 4);
        row1a.createCell(0).setCellValue("1");
        row2a.createCell(0).setCellValue("2");
        row3a.createCell(0).setCellValue("3");
        row4a.createCell(0).setCellValue("4");
// National
        HSSFSheet sheetnat = workbook.createSheet("Live");
        HSSFRow rownat = sheetnat.createRow((short) 0);
        rownat.createCell(0).setCellValue("No.");
        rownat.createCell(1).setCellValue("Show");
        HSSFRow row1nat = sheetnat.createRow((short) 1);
        HSSFRow row2nat = sheetnat.createRow((short) 2);
        HSSFRow row3nat = sheetnat.createRow((short) 3);
        HSSFRow row4nat = sheetnat.createRow((short) 4);
        row1nat.createCell(0).setCellValue("1");
        row2nat.createCell(0).setCellValue("2");
        row3nat.createCell(0).setCellValue("3");
        row4nat.createCell(0).setCellValue("4");
        row1nat.createCell(1).setCellValue(nat_l.get(nat_l.size() - 4));
        row2nat.createCell(1).setCellValue(nat_l.get(nat_l.size() - 3));
        row3nat.createCell(1).setCellValue(nat_l.get(nat_l.size() - 2));
        row4nat.createCell(1).setCellValue(nat_l.get(nat_l.size() - 1));
//        // Create xls output file
        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        Utility.deleteFileOnDesktop(new File("foxjsoup.xls"));
    }
}
