import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//just for testing
public class MainTest1 {

    @Test
    public  void test1class1() throws InterruptedException {
        int currentTestValue = 11;
        Singleton test1class1 = Singleton.getInstance();
        test1class1.setvalue(currentTestValue);

        Thread.sleep(5000);

        long id = Thread.currentThread().getId();

        System.out.println("Actul " + test1class1.returnRandomValue() + " Expected " + currentTestValue + " class 1 test 1. Thread id is: " + id);


        assertEquals(test1class1.returnRandomValue(), currentTestValue);
    }

    @Test
    public  void test2(){
        int currentTestValue = 112;
        Singleton test2class1 = Singleton.getInstance();
        test2class1.setvalue(currentTestValue);

        long id = Thread.currentThread().getId();


        assertEquals(test2class1.returnRandomValue(), currentTestValue);
        System.out.println("Actual: "+test2class1.returnRandomValue() + " Expected " + currentTestValue + " class 1 test 2. Thread id is: " + id);
    }

}
