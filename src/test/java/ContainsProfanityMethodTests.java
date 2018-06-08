import org.junit.Test;

public class ContainsProfanityMethodTests extends BaseTest {

    @Test
    public void containsProfanityPositive(){
        expectedValue = "true";
        queryUrl += "containsprofanity?text=shit";
        getContainsProfanity(queryUrl, expectedValue, OK);
    }

    @Test
    public void containsProfanityNegative(){
        expectedValue = "false";
        queryUrl += "containsprofanity?text=car";
        getContainsProfanity(queryUrl, expectedValue, OK);
    }
}
