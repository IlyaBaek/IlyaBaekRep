public class Singleton {
    private static Singleton someObject;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(someObject == null)
        {
            someObject = new Singleton();
        }
        return someObject;
    }

    public void demoMetod(){
        System.out.println("demo");
    }
}


