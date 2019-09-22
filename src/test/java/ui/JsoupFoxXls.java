package ui;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupFoxXls {
    public static void main(String[] args)throws IOException {
        String filename = System.getProperty("user.dir")+"/Desktop/fox.xls";
        String xpath = "div[class*='Tile_details']";
        List<String> shows_l = new ArrayList<String>();
        List<String> fx_l = new ArrayList<String>();
        List<String> nat_l = new ArrayList<String>();
        List<String> sport_l = new ArrayList<String>();
        List<String> all_l = new ArrayList<String>();
        String urlshows = "https://www.fox.com/shows/";
        Document shows = Jsoup.connect(urlshows).get();
        Elements shows_ = shows.select(xpath);
        int shows_size = shows_.size();
        for (int i = 0; i < shows_size; ++i)
            shows_l.add(shows_.get(i).text());
        String urlfx = "https://www.fox.com/shows/collection/fx/";
        Document fx = Jsoup.connect(urlfx).get();
        Elements fx_ = fx.select(xpath);
        int fx_size = fx_.size();
        for (int i = 0; i < fx_size; ++i)
            fx_l.add(fx_.get(i).text());
        String urlnat = "https://www.fox.com/shows/collection/national%20geographic/";
        Document nat = Jsoup.connect(urlnat).get();
        Elements nat_ = nat.select(xpath);
        int nat_size = nat_.size();
        for (int i = 0; i < nat_size; ++i)
            nat_l.add(nat_.get(i).text());
        String urlsport = "https://www.fox.com/shows/collection/fox%20sports/";
        Document sport = Jsoup.connect(urlsport).get();
        Elements sport_ = sport.select(xpath);
        int sport_size = sport_.size();
        for (int i = 0; i < sport_size; ++i)
            sport_l.add(sport_.get(i).text());
        String urlall = "https://www.fox.com/shows/collection/all%20shows/";
        Document all = Jsoup.connect(urlall).get();
        Elements all_ = all.select(xpath);
        int all_size = all_.size();
        for (int i = 0; i < all_size; ++i)
            all_l.add(all_.get(i).text());
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
        row1.createCell(1).setCellValue(shows_l.get(shows_l.size()-4));
        row2.createCell(1).setCellValue(shows_l.get(shows_l.size()-3));
        row3.createCell(1).setCellValue(shows_l.get(shows_l.size()-2));
        row4.createCell(1).setCellValue(shows_l.get(shows_l.size()-1));
//        // Fox
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
        row1n.createCell(1).setCellValue(fx_l.get(fx_l.size()-4));
        row2n.createCell(1).setCellValue(fx_l.get(fx_l.size()-3));
        row3n.createCell(1).setCellValue(fx_l.get(fx_l.size()-2));
        row4n.createCell(1).setCellValue(fx_l.get(fx_l.size()-1));
//        // FOX Sports
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
        row1s.createCell(1).setCellValue(sport_l.get(sport_l.size()-4));
        row2s.createCell(1).setCellValue(sport_l.get(sport_l.size()-3));
        row3s.createCell(1).setCellValue(sport_l.get(sport_l.size()-2));
        row4s.createCell(1).setCellValue(sport_l.get(sport_l.size()-1));
//        // All shows
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
        row1a.createCell(1).setCellValue(all_l.get(all_l.size()-4));
        row2a.createCell(1).setCellValue(all_l.get(all_l.size()-3));
        row3a.createCell(1).setCellValue(all_l.get(all_l.size()-2));
        row4a.createCell(1).setCellValue(all_l.get(all_l.size()-1));
//// National
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
        row1nat.createCell(1).setCellValue(nat_l.get(nat_l.size()-4));
        row2nat.createCell(1).setCellValue(nat_l.get(nat_l.size()-3));
        row3nat.createCell(1).setCellValue(nat_l.get(nat_l.size()-2));
        row4nat.createCell(1).setCellValue(nat_l.get(nat_l.size()-1));
//        // Create xls output file
        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}