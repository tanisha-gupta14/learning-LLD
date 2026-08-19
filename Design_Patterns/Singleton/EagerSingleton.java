package Design_Patterns.Singleton;

public class EagerSingleton {
    private static EagerSingleton instance=new EagerSingleton();
    private EagerSingleton() {
        System.out.println("EagerSingleton instance created");
    }
    public static EagerSingleton getInstance(){
        return instance;
    }
    public static void main(String[] args) {
        EagerSingleton s1=EagerSingleton.getInstance();
        EagerSingleton s2=EagerSingleton.getInstance();
        System.out.println(s1==s2);
    }

}
