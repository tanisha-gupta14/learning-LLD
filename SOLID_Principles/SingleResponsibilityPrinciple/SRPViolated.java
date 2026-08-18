package SOLID_Principles.SingleResponsibilityPrinciple;

import java.util.*;

class Product{
    public String name;
    public double price;
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
}

// This class violates the Single Responsibility Principle because it has multiple responsibilities: managing products and calculating the total price of the shopping cart.
// It also has a method to print the invoice and save the shopping cart to a database, which are unrelated responsibilities.

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
    public void printInvoice(){
        System.out.println("Invoice:");
        for(Product p: products){
            System.out.println(p.name + " - $" + p.price);
        }
        System.out.println("Total: $" + calculateTotal());
    }
    public void saveToDatabase(){
        // Code to save the shopping cart to a database
        System.out.println("Shopping cart saved to database.");
    }
}
public class SRPViolated {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Apple", 1.0));
        cart.addProduct(new Product("Banana", 0.5));
        cart.printInvoice();
        cart.saveToDatabase();
    }
}