package Design_Patterns;

/*
 * Defines a family of algorithms, put them into separate classes, so that they can be changed at runtime.
 */


interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

class UpiPayment implements PaymentStrategy{
    private String upiId;
    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI: " + upiId);
    }
}

class PaymentService {
    private PaymentStrategy paymentStrategy;
    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void processPayment(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyDesignPattern {
    public static void main(String[] args) {
       PaymentService paymentService1 = new PaymentService(new CreditCardPayment("1234-5678-9012-3456"));
       paymentService1.processPayment(100);
       PaymentService paymentService2 = new PaymentService(new UpiPayment("user@upi"));
       paymentService2.processPayment(200);
    }
}
