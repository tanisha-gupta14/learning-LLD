package Design_Patterns;

class PaymentService{
    public void processPayment(){
        System.out.println("Payment processed successfully.");
    }
}

class InventoryService{
    public void updateInventory(){
        System.out.println("Inventory updated successfully.");
    }
}

class ShippingService{
    public void createShipping(){
        System.out.println("Shipping created successfully.");
    }
}

class NotificationService{
    public void sendNotification(){
        System.out.println("Order Confirmation sent to customer.");
    }
}

class CheckOutFacade{
    private PaymentService paymentService;
    private InventoryService inventoryService;
    private ShippingService shippingService;
    private NotificationService notificationService;

    public CheckOutFacade(){
        this.paymentService = new PaymentService();
        this.inventoryService = new InventoryService();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    public void placeOrder(){
        paymentService.processPayment();
        inventoryService.updateInventory();
        shippingService.createShipping();
        notificationService.sendNotification();

        System.out.println("Order placed successfully.");
    }
}

public class FacadeDesignPattern {
    public static void main(String[] args) {
        CheckOutFacade checkoutFacade = new CheckOutFacade();
        checkoutFacade.placeOrder();
    }
}
