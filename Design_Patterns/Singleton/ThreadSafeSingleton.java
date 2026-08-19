package Design_Patterns.Singleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance=null;
    private ThreadSafeSingleton() {
        System.out.println("ThreadSafeSingleton instance created");
    }
    public static ThreadSafeSingleton getInstance(){
        if(instance==null){
            synchronized (ThreadSafeSingleton.class){
                if(instance==null){
                    instance=new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        ThreadSafeSingleton s1=ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton s2=ThreadSafeSingleton.getInstance();
        System.out.println(s1==s2);
    }
}
