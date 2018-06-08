import org.junit.Test;

public class TextParameterTests extends BaseTest{

    @Test
    public void oneProfanityOneNonProfanityTextWithChar(){

        expectedValue = "*****man";
        queryUrl += "json?text=*shitman";

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, resultKey);
    }

    @Test
    public void queryWithoutTextParameter(){

        expectedValue = "No Input";
        queryUrl += "json";

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, errorKey);
    }

    @Test
    public void queryWithoutJsonResponseTypeParameter(){

        queryUrl += "?text=man";

        getURLExpectingStatusCode(queryUrl, notAllowed);
    }

    @Test
    public void profanityTextWithSpecialSymbols(){

        expectedValue = "**** *** **** ***";
        queryUrl += "json?text=sh!t @ss (unt a$$";

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, resultKey);
    }
}
