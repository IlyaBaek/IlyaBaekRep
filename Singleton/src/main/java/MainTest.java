import org.testng.annotations.Test;

//just for testing
public class MainTest {

    @Test
    public  void Main(){
        Singleton any = Singleton.getInstance();

        System.out.println(any.returnRandomValue());
    }

}
