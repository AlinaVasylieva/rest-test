import org.junit.Test;

public class FillCharsMethodTests extends BaseTest{

    @Test
    public void fillCharAcceptableChars(){

        expectedValue = "||||";
        String profanityWord = "shit";
        String fillChar = "|";
        queryUrl += "json?text=" + profanityWord +
                "&fill_char=" + fillChar;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, resultKey);
    }

    @Test
    public void fillCharNotAcceptableChars(){

        expectedValue = "Invalid User Replacement Characters";
        String profanityWord = "shit";
        String fillChar = "@";
        queryUrl += "json?text=" + profanityWord +
                "&fill_char=" + fillChar;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, errorKey);
    }

    @Test
    public void fillCharEqualSign(){

        expectedValue = "====";
        String profanityWord = "shit";
        String fillChar = "=";
        queryUrl += "json?text=" + profanityWord +
                "&fill_char=" + fillChar;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, resultKey);
    }

}
