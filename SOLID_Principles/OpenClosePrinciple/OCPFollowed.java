package SOLID_Principles.OpenClosePrinciple;
import java.util.*;

/*
 * Open-Closed Principle: A class should be open for extension but closed for modification. This means that you should be able to add new functionality to a class without changing its existing code.
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

interface Persistence{
    void save(ShoppingCart cart);
}

class SQLPersistence implements Persistence{
    
    public void save(ShoppingCart cart){
        // Code to save the shopping cart to a SQL database
        System.out.println("Shopping cart saved to SQL database.");
    }
}

class MongoDBPersistence implements Persistence{
    
    public void save(ShoppingCart cart){
        // Code to save the shopping cart to a MongoDB database
        System.out.println("Shopping cart saved to MongoDB.");
    }
}

class FilePersistence implements Persistence{
    
    public void save(ShoppingCart cart){
        // Code to save the shopping cart to a file
        System.out.println("Shopping cart saved to file.");
    }
}

public class OCPFollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Apple", 1.0));
        cart.addProduct(new Product("Banana", 0.5));
        
        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();
        
        Persistence sqlPersistence = new SQLPersistence();
        sqlPersistence.save(cart);
        
        Persistence mongoPersistence = new MongoDBPersistence();
        mongoPersistence.save(cart);
        
        Persistence filePersistence = new FilePersistence();
        filePersistence.save(cart);
    }
}
