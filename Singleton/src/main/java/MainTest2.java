import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MainTest2 {

    @Test
    public  void test1class2(){
        int currentTestValue = 12;
        Singleton test1class2 = Singleton.getInstance();
        test1class2.setvalue(currentTestValue);

        long id = Thread.currentThread().getId();
        System.out.println("Actual: "+test1class2.returnRandomValue() + " Expected " + currentTestValue + " class 2 test 1. Thread id is: " + id);

        assertEquals(test1class2.returnRandomValue(), currentTestValue);
    }
}
