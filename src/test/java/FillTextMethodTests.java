import org.junit.Test;

public class FillTextMethodTests extends BaseTest {

    @Test
    public void fillProfanityWithProfanity(){

        expectedValue = "****";
        String profanityWord = "shit";
        queryUrl += "json?text=" + profanityWord +
                "&fill_text=" + profanityWord;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, resultKey);
    }

    @Test
    public void fillProfanity20Chars(){

        expectedValue = "a20_~!-=|'\"*}{()[]0A";
        String fillTextParameter = "a20_~!-=|'\"*}{()[]0A";
        queryUrl += "json?text=shit" +
                "&fill_text=" + fillTextParameter;


        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, resultKey);
    }

    @Test
    public void fillProfanity20CharsWithNotAllowedOnes(){

        expectedValue = "Invalid User Replacement Text";
        String profanityCharsSpecial = "a20_~!-=?,'\"}*)}([}0";
        queryUrl += "json?text=" + profanityCharsSpecial +
                "&fill_text=" + profanityCharsSpecial;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, errorKey);
    }

    @Test
    public void fillProfanity21Chars(){

        expectedValue = "User Replacement Text Exceeds Limit of 20 Characters.";

        String profanityCharsExceeded = "a21_~!-=**'\"}*)}([}0-";
        queryUrl += "json?text=" + profanityCharsExceeded +
                "&fill_text=" + profanityCharsExceeded;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, errorKey);
    }

}
