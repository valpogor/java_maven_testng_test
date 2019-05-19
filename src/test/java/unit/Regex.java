package unit;

import common.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://regex101.com/
public class Regex {
    String regex = "(?<=<author>).+?(?=</author)";
    String regexTytle = "(?<=<title>).+?(?=</title)";
    String text = "<w:r>\n" +
            "<w:rPr>\n" +
            "<w:rFonts w:ascii=\"Helvetica\" w:h-ansi=\"Helvetica\" w:cs=\"Helvetica\"/>\n" +
            "<wx:font wx:val=\"Helvetica\"/>\n" +
            "<w:sz w:val=\"24\"/>\n" +
            "<w:sz-cs w:val=\"24\"/>\n" +
            "</w:rPr>\n" +
            "<w:t> <author>Gambardella, Matthew</author></w:t>\n" +
            "</w:r>\n" +
            "</w:p>\n" +
            "<w:p>\n" +
            "<w:pPr/>\n" +
            "<w:r>\n" +
            "<w:rPr>\n" +
            "<w:rFonts w:ascii=\"Helvetica\" w:h-ansi=\"Helvetica\" w:cs=\"Helvetica\"/>\n" +
            "<wx:font wx:val=\"Helvetica\"/>\n" +
            "<w:sz w:val=\"24\"/>\n" +
            "<w:sz-cs w:val=\"24\"/>\n" +
            "</w:rPr>\n" +
            "<w:rFonts w:ascii=\"Helvetica\" w:h-ansi=\"Helvetica\" w:cs=\"Helvetica\"/>\n" +
            "<wx:font wx:val=\"Helvetica\"/>\n" +
            "<w:sz w:val=\"24\"/>\n" +
            "<w:sz-cs w:val=\"24\"/>\n" +
            "</w:rPr>\n" +
            "<w:t> <author>Ivan, Matthewan</author></w:t>\n" +
            "</w:r>\n" +
            "</w:p>\n" +
            "<w:p>\n" +
            "<w:pPr/>\n" +
            "<w:r>\n" +
            "<w:rPr>\n" +
            "<w:rFonts w:ascii=\"Helvetica\" w:h-ansi=\"Helvetica\" w:cs=\"Helvetica\"/>\n" +
            "<wx:font wx:val=\"Helvetica\"/>\n" +
            "<w:sz w:val=\"24\"/>\n" +
            "<w:sz-cs w:val=\"24\"/>\n" +
            "</w:rPr>\n" +
            "<w:t> <title>XML Developer's Guide</title></w:t>\n" +
            "</w:r>\n" +
            "</w:p>\n" +
            "<w:p>";
    File fileXmlBooks = new File(System.getProperty("user.home")+"/Desktop/qalife/src/test/resources/Files/books.xml");

    @Test
    public void regexFoundFromStringTextByAuthor() throws Exception{
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile(regex)
                .matcher(text);
        while (m.find()) {
            allMatches.add(m.group());
        }
        System.out.println("Found in text: "+allMatches+"\n");
    }

    @Test
    public void regexFoundFromStringInFileByAuthor() {
        Utility.ReadXMLFile(fileXmlBooks, regex);
    }
    @Test
    public void regexFoundFromStringInFileByTitle() {
        Utility.ReadXMLFile(fileXmlBooks, regexTytle);
    }
}
