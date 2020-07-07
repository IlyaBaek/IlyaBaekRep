import java.util.Random;

public class Singleton {
    private static Singleton object;
    Random rand = new Random();
    int randomValue;

    private Singleton(){
        randomValue = rand.nextInt();
    }

    public static Singleton getInstance(){
        if(object == null)
        {
            object = new Singleton();
        }
        return object;
    }

    public int returnRandomValue(){
        return randomValue;
    }
}



