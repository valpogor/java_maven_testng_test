package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import pages.LoginPage;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility extends LoginPage {

    public static void waitUntilElementDisplayed(WebDriver driver, int sec, By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }

    public static void waitUntilElementDisappear(WebDriver driver, int sec, By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

    }

    public static String toCurrency(double number) {
        Locale loc = new Locale("en", "US");
        NumberFormat curForm = NumberFormat.getCurrencyInstance(loc);
        System.out.print("Converted to currency: " + curForm.format(number) + "\n");
        return curForm.format(number);
    }

    public static void clickJs(WebDriver driver, String element) {
        WebElement button = driver.findElement(By.id(element));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", button);
    }

    public static void waitForUrlContains(WebDriver driver, String expectedString, int TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.urlContains(expectedString));
    }

    public static File[] readAllNamesFilesFromDesktop() {
        File folder = new File(System.getProperty("user.home"), "/Desktop");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
        return listOfFiles;
    }

    public static void deleteFileOnDesktop(File namefile) {
        File xx = new File(System.getProperty("user.home"), "/Desktop/" + namefile);
        if (xx.exists()) {
            xx.delete();
        }
    }

    public static ArrayList<String> collecElementTxt(WebDriver driver, String xpath) {
        List<WebElement> phones = driver.findElements(By.xpath(xpath));
        ArrayList<String> ph = new ArrayList<String>();
        System.out.println("Total No of links Available: " + phones.size());
        for (int i = 0; i < phones.size(); i++) {
            phones.get(i).getText();
            ph.add(phones.get(i).getText());
            System.out.println(phones.get(i).getText());
        }
        return ph;
    }

    public static void SendMailSSLWithAttachment() {
        // Create object of Property file
        Properties props = new Properties();
        String email = "qalifetest@gmail.com";
        // this will set host of server- you can change based on your requirement
        props.put("mail.smtp.host", "smtp.gmail.com");
        // set the port of socket factory
        props.put("mail.smtp.socketFactory.port", "465");
        // set socket factory
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // set the authentication to true
        props.put("mail.smtp.auth", "true");
        // set the port of SMTP server
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable", "true");
        // This will handle the complete authentication
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, "Deploy19");
                    }

                });
        try {
            // Create object of MimeMessage class
            Message message = new MimeMessage(session);
            // Set the from address
            message.setFrom(new InternetAddress(email));
            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            // Add the subject link
            message.setSubject("Testing Subject");
            // Create object to add multimedia type content
            BodyPart messageBodyPart1 = new MimeBodyPart();
            // Set the body of email
            messageBodyPart1.setText("This is message body");
            // Create another object to add another content
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            // Mention the file which you want to send
            File xx = new File(System.getProperty("user.home"), "/Desktop/qastarting_repo/target/surefire-reports/");
            String filename = "emailable-report.html";
            // Create data source and pass the filename
            DataSource source = new FileDataSource(xx + "/" + filename);
            // set the handler
            if (((FileDataSource) source).getFile().exists()) {
                messageBodyPart2.setDataHandler(new DataHandler(source));
                // set the file
                messageBodyPart2.setFileName(filename);
                // Create object of MimeMultipart class
                Multipart multipart = new MimeMultipart();
                // add body part 1
                multipart.addBodyPart(messageBodyPart2);
                // add body part 2
                multipart.addBodyPart(messageBodyPart1);
                // set the content
                message.setContent(multipart);
                // finally send the email
                Transport.send(message);
                System.out.println("\n" + ANSI_CYAN + "===Email Sent===" + ANSI_PURPLE + "===To: " + ANSI_PURPLE + email + " ===!" + ANSI_BLUE + "===With File: " + filename + ANSI_RESET + "\n");
            } else {
                System.out.println("\n" + ANSI_CYAN + "File doesn't exists " + ANSI_RESET + "\n");
            }
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ReadXMLFile(File file, String regex) {
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            for (int count = 0; count < (doc.getChildNodes()).getLength(); count++) {

                Node tempNode = (doc.getChildNodes()).item(count);
                List<String> allMatches = new ArrayList<String>();
                Matcher m = Pattern.compile(regex)
                        .matcher(tempNode.getTextContent());
                while (m.find()) {
                    allMatches.add(m.group());
                }
                if(allMatches.size()!=0){
                    System.out.println("Found in text: "+allMatches+"\n");}

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
