import org.junit.Test;

public class NonFunctionalTests extends BaseTest{

    @Test
    public void stressTest100queries(){
        long expectedResponseTime = 2000L;
        for(int i = 0; i < 100; i++){
            getCodeAndResponseTime(queryUrl + "json?text=shit", OK, expectedResponseTime);
        }
    }
}
