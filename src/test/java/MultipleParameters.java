import org.junit.Test;

public class MultipleParameters extends BaseTest {

    @Test
    public void addProfanityFillText(){

        expectedValue = "a20_~!-=|'\"*}{()[]0A , a20_~!-=|'\"*}{()[]0A , a20_~!-=|'\"*}{()[]0A , a20_~!-=|'\"*}{()[]0A";
        String wordsParameter = "cat,martin176_,bee-_,1234";
        String fillTextParameter = "a20_~!-=|'\"*}{()[]0A";
        queryUrl += "json?text=" + wordsParameter +
                "&add=" + wordsParameter+
                "&fill_text=" + fillTextParameter;

        getURLExpectingStatusCodeAndValue(queryUrl, OK, expectedValue, resultKey);
    }


}
