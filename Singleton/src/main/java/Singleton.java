import java.util.Random;

public class Singleton {
    private static Singleton object;
    private Random rand = new Random();
    private ThreadLocal<Integer> randomValue = new ThreadLocal<>();

    private Singleton(){
        //randomValue = rand.nextInt();
        randomValue.set(0);
    }

    public static Singleton getInstance(){
        if(object == null)
        {
            object = new Singleton();
        }
        return object;
    }

    public int returnRandomValue(){
        return randomValue.get();
    }

    public void setvalue(int myValue){
        randomValue.set(myValue);
    }
}



