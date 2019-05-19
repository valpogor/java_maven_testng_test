package ApiTests.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * These examples demonstrate Rest Assured functionality that was not used in the case study.
 */
public class RestAssuredJSONExamplesTest extends LoginPage {

    @Test
    public void simpleJSONRestAssuredExample(){

        RestAssured.
            when().
                get(jsonendpoint).
            then().assertThat().
                body("projects.project[0].name",
                        equalTo("A New Projectaniheeiadtatd"));
    }

    @Test
    public void simpleJSONRestAssuredExampleCreated(){

        RestAssured.
            when().
                get(jsonendpoint).
            then().assertThat().
                body("projects.project[0].created-at",
                        equalTo("2017-06-27T12:25:26+01:00"));
    }

    @Test
    public void aJsonRestAssuredExample() {

        RestAssured.
        when().
                get(jsonendpoint).
        then().assertThat().
                body("projects.project.size",
                        equalTo(6)).and().
                body("projects.project[1].name",
                        equalTo("the new name aniheeiaosono")).and().
                body("projects.project[1].id",
                    equalTo(3)).and().
                body("projects.project.find {it.id == 3}.name",
                        equalTo("the new name aniheeiaosono")).and().
                body("projects.project.findAll {it.id <= 6}.size",
                        equalTo(4));

    }


    @Test
    public void aSetOfJsonPathExamples(){

        File jsonExample = new File(System.getProperty("user.dir"),
                "src/test/resources/jsonxml/jsonexample.json");

        JsonPath jsonPath = new JsonPath(jsonExample);

        // multiple matches returned in an ArrayList
        ArrayList ret = jsonPath.get("projects.project");
        Assert.assertEquals(6, ret.size());

        // can index on multiple matches with array indexing notation [1]
        Assert.assertEquals("the new name aniheeiaosono",jsonPath.get("projects.project[1].name"));
        Assert.assertEquals(3,jsonPath.getInt("projects.project[1].id"));

        // can count backwards so -1 is last, -2 is second to last
        Assert.assertEquals(10,jsonPath.getInt("projects.project[-1].id"));

        // filters and finding stuff
        // find the project with id == '3' and return the name
        Assert.assertEquals("the new name aniheeiaosono",jsonPath.get("projects.project.find {it.id == 3}.name"));

        // use `findAll` to find all the items that match a condition
        // conditions can use Groovy so convert the id to an integer in the filter if it was a string with  `{it.id.toInteger() <= 6}`

        // use `it` in the filter condition to refer to currently matched item
        ArrayList projectsWithIdLessThanSix = jsonPath.get("projects.project.findAll {it.id <= 6}");
        Assert.assertEquals(4,projectsWithIdLessThanSix.size());



        // get an 'object' as a Map from the list
        Map<String, Object> project1map = jsonPath.getMap("projects.project[1]");
        Assert.assertEquals("active", project1map.get("state"));


        // set root to an element in the Json to make accessing it easier
        JsonPath project2 = new JsonPath(jsonExample).setRoot("projects.project[2]");
        Assert.assertEquals(5 ,project2.getInt("id"));
        Assert.assertEquals("active" ,project2.get("state"));




    }

    @Test
    public void aJsonPathExampleFromResponse(){

        /*
            Use RestAssured to return response from HTTP to demonstrate same as using JsonPath on String
         */
        Response response = RestAssured.
                when().
                get(jsonendpoint).
                andReturn();

        JsonPath jsonPath = new JsonPath(response.body().asString());

        // multiple matches returned in an ArrayList
        List<HashMap<String,String>> ret = jsonPath.get("projects.project");
        Assert.assertEquals(6, ret.size());

        Assert.assertEquals("A New Projectaniheeiadtatd",
                            ret.get(0).get("name"));

        // can index on multiple matches with array indexing notation [1]
        Assert.assertEquals("the new name aniheeiaosono",jsonPath.get("projects.project[1].name"));
        Assert.assertEquals(3,jsonPath.getInt("projects.project[1].id"));

        // filters and finding stuff
        // find the project with id == '3' and return the name
        Assert.assertEquals("the new name aniheeiaosono",jsonPath.get("projects.project.find {it.id == 3}.name"));

        // use `findAll` to find all the items that match a condition
        ArrayList projectsWithIdLessThanSix = jsonPath.get("projects.project.findAll {it.id <= 6}");
        Assert.assertEquals(4,projectsWithIdLessThanSix.size());

    }

}