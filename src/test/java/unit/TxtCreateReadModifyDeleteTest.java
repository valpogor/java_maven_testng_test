package unit;

import com.github.javafaker.Faker;
import common.Utility;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.Random;

public class TxtCreateReadModifyDeleteTest extends LoginPage {

    public Faker faker = new Faker();
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";

    @Test
    public void createEmptyTxtOnDesktop() throws Exception {
        Utility.createFileHtmlOnDesktop("kjhvkjbln.:>Ln;ln;legn;klwneqrgklnqwr:GKLNq.wkrnljkwbgl/kbwlkebgkl");
        Utility.createFileHtmlOnDesktop("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "table {\n" +
                "  font-family: arial, sans-serif;\n" +
                "  border-collapse: collapse;\n" +
                "  width: 100%;\n" +
                "}\n" +
                "\n" +
                "td, th {\n" +
                "  border: 1px solid #dddddd;\n" +
                "  text-align: left;\n" +
                "  padding: 8px;\n" +
                "}\n" +
                "\n" +
                "tr:nth-child(even) {\n" +
                "  background-color: #dddddd;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h2>HTML Table</h2>\n" +
                "\n" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th>Company</th>\n" +
                "    <th>Contact</th>\n" +
                "    <th>Country</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Alfreds Futterkiste</td>\n" +
                "    <td>Maria Anders</td>\n" +
                "    <td>Germany</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Centro comercial Moctezuma</td>\n" +
                "    <td>Francisco Chang</td>\n" +
                "    <td>Mexico</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Ernst Handel</td>\n" +
                "    <td>Roland Mendel</td>\n" +
                "    <td>Austria</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Island Trading</td>\n" +
                "    <td>Helen Bennett</td>\n" +
                "    <td>UK</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Laughing Bacchus Winecellars</td>\n" +
                "    <td>Yoshi Tannamuri</td>\n" +
                "    <td>Canada</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Magazzini Alimentari Riuniti</td>\n" +
                "    <td>Giovanni Rovelli</td>\n" +
                "    <td>Italy</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n");
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
