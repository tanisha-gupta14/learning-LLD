package SOLID_Principles.InterfaceSegregationPrinciple;
import java.util.*;

interface Shape{
    double area();
    double volume();
}

class Square implements Shape{
    private double side;
    public Square(double side){
        this.side = side;
    }
    public double area(){
        return side * side;
    }
    public double volume(){
        throw new UnsupportedOperationException("Volume not supported for square");
    }
}

class Cube implements Shape{
    private double side;
    public Cube(double side){
        this.side = side;
    }
    public double area(){
        return 6 * side * side;
    }
    public double volume(){
        return side * side * side;
    }
}

public class ISPViolated {
    public static void main(String[] args) {
        Shape square = new Square(5);
        Shape cube = new Cube(3);
        System.out.println("Square area: " + square.area());
        System.out.println("Cube area: " + cube.area());
        System.out.println("Cube volume: " + cube.volume());
        try {
            System.out.println("Square volume: " + square.volume());
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
