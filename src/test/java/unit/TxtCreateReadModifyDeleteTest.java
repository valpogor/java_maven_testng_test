package unit;

import com.github.javafaker.*;
import org.testng.annotations.*;
import pages.LoginPage;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.text.*;
import java.util.*;

public class TxtCreateReadModifyDeleteTest extends LoginPage {
    public Faker faker = new Faker();
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";
    @Test
    public void createEmptyTxtOnDesktop() throws Exception {
        File desktop = new File(System.getProperty("user.home"), "/Desktop");
        DateFormat df = new SimpleDateFormat("ddMMyy");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
        String firstName = faker.name().firstName();
        String random = faker.gameOfThrones().character();
        File textFile = new File(desktop, df.format(dateobj) + "_" + random + firstName + ".html");
        BufferedWriter out = new BufferedWriter(new FileWriter(textFile));
        out.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>HTML Forms</h2>\n" +
                "\n" +
                "<form action=\"/action_page.php\">\n" +
                "  First name:<br>\n" +
                "  <input type=\"text\" name=\"firstname\" value=\"Test1\">\n" +
                "  <br>\n" +
                "  Last name:<br>\n" +
                "  <input type=\"text\" name=\"lastname\" value=\"Mouse\">\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> \n" +
                "\n" +
                "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/action_page.php\".</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n");
        out.close();
    }
    @Test
    public void createRandomFakeNameLastAddress() throws Exception{
        String name = faker.name().fullName();
        String lastName = faker.name().lastName();
        String streetAddress = faker.address().streetAddress();
        String gameOfThronesChar = faker.gameOfThrones().character();
        System.out.print(ANSI_GREEN_BACKGROUND + name +"\n"+ ANSI_RESET);
        System.out.print(ANSI_RED_BACKGROUND + lastName +"\n"+ ANSI_RESET);
        System.out.print(ANSI_GREEN_BACKGROUND + streetAddress +"\n"+ ANSI_RESET);
        System.out.print(ANSI_RED_BACKGROUND + gameOfThronesChar +"\n"+ ANSI_RESET);

    }
    @Test
    public void createRandomNumbers() {
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(1000);
        int rand_int2 = rand.nextInt(1000);

        // Print random integers
        System.out.println("Random Integers: "+rand_int1);
        System.out.println("Random Integers: "+rand_int2);

        // Generate Random doubles
        double rand_dub1 = rand.nextDouble();
        double rand_dub2 = rand.nextDouble();

        // Print random doubles
        System.out.println("Random Doubles: "+rand_dub1);
        System.out.println("Random Doubles: "+rand_dub2);

    }
}
