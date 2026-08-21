package Design_Patterns;

// Target interface used by our application
interface PaymentProcessor {
    void pay(double amount);
}


// Third-party class
// Assume this comes from an external payment library
class StripePaymentGateway {

    public void makePaymentInCents(int amountInCents) {
        System.out.println(
                "Stripe processed payment of " + amountInCents + " cents"
        );
    }
}


// Adapter class
class StripePaymentAdapter implements PaymentProcessor {

    private final StripePaymentGateway stripeGateway;

    public StripePaymentAdapter() {
        this.stripeGateway = new StripePaymentGateway();
    }

    @Override
    public void pay(double amount) {

        // Third-party API expects amount in cents
        int amountInCents = (int) Math.round(amount * 100);

        stripeGateway.makePaymentInCents(amountInCents);
    }
}


// Client class

public class AdapterDesignPattern {
    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new StripePaymentAdapter();

        paymentProcessor.pay(50.75);
        paymentProcessor.pay(100.00);
        paymentProcessor.pay(25.50);
    }
}
