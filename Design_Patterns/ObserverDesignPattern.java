package Design_Patterns;
import java.util.*;

interface ISubscriber{
    void update();
}

interface IChannel{
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifySubscribers();
}

class Channel implements IChannel{
    private List<ISubscriber>subscribers = new ArrayList<>();
    private String name;
    private String latestVideo;

    public Channel(String name){
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(ISubscriber subscriber){
        if(!subscribers.contains(subscriber))
        subscribers.add(subscriber);
    }
    public void unsubscribe(ISubscriber subscriber){
        subscribers.remove(subscriber);
    }
    public void notifySubscribers(){
        for(ISubscriber subscriber: subscribers){
            subscriber.update();
        }
    }
    public void uploadVideo(String videoTitle){
        this.latestVideo = videoTitle;
        System.out.println("New video uploaded: " + videoTitle);
        notifySubscribers();
    }
    public String getLatestVideo(){
        return "check out our new video:"+ latestVideo+"\n";
    }
}

class Subscriber implements ISubscriber{
    private String name;
    private Channel channel;
    
    public Subscriber(String name, Channel channel){
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update(){
        System.out.println(name + " received notification: " + channel.getLatestVideo());
    }

}

public class ObserverDesignPattern {
    public static void main(String[] args){
        Channel channel = new Channel("TechWorld");
        Subscriber subscriber1 = new Subscriber("Alice", channel);
        Subscriber subscriber2 = new Subscriber("Bob", channel);

        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);

        channel.uploadVideo("Observer Design Pattern Explained");
        channel.uploadVideo("Understanding Java");

        channel.unsubscribe(subscriber1);
        channel.uploadVideo("Design Patterns in Java");
    }
}
