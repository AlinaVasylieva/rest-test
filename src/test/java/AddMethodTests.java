import org.junit.Test;

public class AddMethodTests extends BaseTest{

    @Test
    public void addProfanityTextMethod10words(){

        expectedValue = "***,****,***,****,***,**,***,***,***,***";
        String tenWordsParameter = "cat,dog1,box,kiT_,hit,hi,may,way,SAY,Day";
        queryUrl += "json?text=" + tenWordsParameter +
                "&add=" + tenWordsParameter;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, resultKey);
    }

    @Test
    public void addProfanityTextMethod10wordsWithCharsNotAcceptable(){

        expectedValue = "Invalid Characters in User Black List";
        String tenWordsParameter = "cat!,dog1,box?,kit_,hit|,hi~,may(,way},sAy,AsS";
        queryUrl += "json?text=" + tenWordsParameter +
                "&add=" + tenWordsParameter;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, errorKey);
    }

    @Test
    public void addProfanityTextMethod11words(){

        expectedValue = "User Black List Exceeds Limit of 10 Words.";
        String elevenWordsParameter = "cat,dog1,box,kit_,hit,hi,may,way,say,day,guy";
        queryUrl += "json?text=" + elevenWordsParameter +
                "&add=" + elevenWordsParameter;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, errorKey);
    }

    @Test
    public void addProfanityTextMethod200Chars(){

        String twoHundredCharsParameter = generate200CharsString();
        expectedValue = "hi";
        queryUrl += "json?text=" + expectedValue +
                "&add=" + twoHundredCharsParameter;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, resultKey);
    }

    @Test
    public void addProfanityTextMethod201Chars(){

        expectedValue = "User Black List Exceeds Limit of 200 Characters.";
        String twoHundredOneCharsParameter = generate200CharsString() + "1";
        queryUrl += "json?text=" + twoHundredOneCharsParameter +
                "&add=" + twoHundredOneCharsParameter;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, errorKey);
    }

    private String generate200CharsString(){
        String value = "";
        String valueToAdd = "ab_1";
        for (int i=1; i <= 50; i++){
            value += valueToAdd;
        }
        return value;
    }
}
