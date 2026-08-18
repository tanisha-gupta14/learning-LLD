package SOLID_Principles.InterfaceSegregationPrinciple;
import java.util.*;

/*
 * Interface Segregation Principle: clients should not be forced to depend on interfaces they do not use. This principle suggests that larger interfaces should be split into smaller, more specific ones so that clients only need to know about the methods that are of interest to them.
 */

interface TwoDimensionalShape{
    double area();
}
interface ThreeDimensionalShape{
    double area();
    double volume();
}
class Square implements TwoDimensionalShape{
    private double side;
    public Square(double side){
        this.side = side;
    }
    public double area(){
        return side * side;
    }
}
class Cube implements ThreeDimensionalShape{
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
public class ISPFollowed {
    public static void main(String[] args) {
        TwoDimensionalShape square = new Square(5);
        ThreeDimensionalShape cube = new Cube(3);
        System.out.println("Square area: " + square.area());
        System.out.println("Cube area: " + cube.area());
        System.out.println("Cube volume: " + cube.volume());
    }
}
