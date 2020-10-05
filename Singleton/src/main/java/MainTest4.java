import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MainTest4 {
    @Test
    public  void test1class3(){
        int currentTestValue = 14;
        Singleton test1class4 = Singleton.getInstance();
        test1class4.setvalue(currentTestValue);

        long id = Thread.currentThread().getId();
        System.out.println("Actual: "+test1class4.returnRandomValue() + " Expected " + currentTestValue + " class 4 test 1. Thread id is: " + id);

        assertEquals(test1class4.returnRandomValue(), currentTestValue);
    }
}
