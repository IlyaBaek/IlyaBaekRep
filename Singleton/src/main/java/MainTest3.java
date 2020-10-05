import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MainTest3 {
    @Test
    public  void test1class3(){
        int currentTestValue = 13;
        Singleton test1class3 = Singleton.getInstance();
        test1class3.setvalue(currentTestValue);

        long id = Thread.currentThread().getId();
        System.out.println("Actual: "+test1class3.returnRandomValue() + " Expected " + currentTestValue + " class 3 test 1. Thread id is: " + id);

        assertEquals(test1class3.returnRandomValue(), currentTestValue);
    }
}
