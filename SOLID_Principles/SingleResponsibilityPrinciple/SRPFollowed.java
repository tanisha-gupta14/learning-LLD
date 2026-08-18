package SOLID_Principles.SingleResponsibilityPrinciple;
import java.util.*;
/*
 * Single Responsibility Principle : A class should have only one reason to change. In other words, a class should have only one responsibility or job.
 */

class Product{
    public String name;
    public double price;
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
}
class ShoppingCart{
    private List<Product>products;
    public ShoppingCart(){
        products = new ArrayList<>();
    }
    public void addProduct(Product p){
        products.add(p);
    }
    public List<Product> getProducts(){
        return products;
    }
    public double calculateTotal(){
        double total = 0;
        for(Product p: products){
            total += p.price;
        }
        return total;
    }
}
class ShoppingCartPrinter{
    private ShoppingCart cart;
    public ShoppingCartPrinter(ShoppingCart cart){
        this.cart = cart;
    }
    public void printInvoice(){
        System.out.println("Invoice:");
        for(Product p: cart.getProducts()){
            System.out.println(p.name + " - $" + p.price);
        }
        System.out.println("Total: $" + cart.calculateTotal());
    }
}
class ShoppingCartDatabaseSaver{
    private ShoppingCart cart;
    public ShoppingCartDatabaseSaver(ShoppingCart cart){
        this.cart = cart;
    }
    public void saveToDatabase(){
        // Code to save the shopping cart to a database
        System.out.println("Shopping cart saved to database.");
    }
}
public class SRPFollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Apple", 1.0));
        cart.addProduct(new Product("Banana", 0.5));
        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();
        ShoppingCartDatabaseSaver saver = new ShoppingCartDatabaseSaver(cart);
        saver.saveToDatabase();
    }
}
