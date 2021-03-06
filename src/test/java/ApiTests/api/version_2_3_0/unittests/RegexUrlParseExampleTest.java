package ApiTests.api.version_2_3_0.unittests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUrlParseExampleTest extends LoginPage {

    @Test
    public void regexExample(){

        String location = "http://localhost/projects/12.xml";

        String findLocation = "[\\S]+?/projects/(\\d+)\\.xml";

        Pattern p = Pattern.compile(findLocation);

        Matcher m = p.matcher(location);

        String projectId = "";
        if (m.find()) {
            projectId = m.group(1);
        }

        Assert.assertEquals("12", projectId);
    }
}