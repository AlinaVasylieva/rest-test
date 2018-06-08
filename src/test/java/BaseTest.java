import org.junit.Assert;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

/**
 * BasePage class contains methods and data to be inherited for other Test classes
 */
public class BaseTest {
    String resultKey = "result";
    String errorKey = "error";
    String expectedValue = "";

    String queryUrl = "http://www.purgomalum.com/service/";
    int OK = 200;
    int notAllowed = 405;

    public void getURLExpectingStatusCodeAndValue(String url, int code, String expectedResponseBodyByKey, String responseBodyKey){
        expect().statusCode(code)
                .body(responseBodyKey, equalTo(expectedResponseBodyByKey))
                .when()
                .get(url);
    }

    public void getURLExpectingStatusCode (String url, int code){
        expect().statusCode(code)
                .when()
                .get(url);
    }

    public void getContainsProfanity(String url, String value, int code){
        String responseValue = expect().statusCode(code)
                .when()
                .get(url).htmlPath().getString("//");

        Assert.assertTrue(value.equals(responseValue));
    }

    public void getCodeAndResponseTime(String url, int code, long responseTimeMaxMilliseconds){
        expect().statusCode(code)
                .when()
                .get(url)
                .then()
                .time(lessThan(responseTimeMaxMilliseconds));
    }

}
