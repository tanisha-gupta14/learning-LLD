package Design_Patterns.Factory;

// a factory class that decides which concrete class to instantiate.

interface Burger{
    void prepare();
}

class BasicBurger implements Burger{
    public void prepare() {
        System.out.println("Preparing Basic Burger");
    }
}

class StandardBurger implements Burger{
    public void prepare() {
        System.out.println("Preparing Standard Burger");
    }
}

class PremiumBurger implements Burger{
    public void prepare() {
        System.out.println("Preparing Premium Burger");
    }
}

class BurgerFactory {
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        } else {
            throw new IllegalArgumentException("Unknown burger type");
        }
    }
}
public class SimpleFactory {
    public static void main(String[] args) {
        String type="premium";
        BurgerFactory burgerFactory = new BurgerFactory();
        Burger burger = burgerFactory.createBurger(type);
        if(burger!=null) {
            burger.prepare();
        }
    }
}
