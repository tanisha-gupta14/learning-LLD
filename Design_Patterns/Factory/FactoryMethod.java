package Design_Patterns.Factory;
// defines an interface for creating objects but allows subclasses to decide which class to instantiate.
interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Basic Burger");
    }
}
class StandardBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Burger");
    }
}
class PremiumBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Premium Burger");
    }
}

class BasicWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger");
    }
}
class StandardWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger");
    }
}
class PremiumWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger");
    }
}

interface BurgerFactory {
    Burger createBurger(String type);
}

class SinghBurger implements BurgerFactory {
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

class KingBurger implements BurgerFactory {
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurger();
        } else {
            throw new IllegalArgumentException("Unknown burger type");
        }
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        String type="basic";
        BurgerFactory burgerFactory = new SinghBurger();
        Burger burger = burgerFactory.createBurger(type);
        if(burger!=null) {
            burger.prepare();
        }
        burgerFactory = new KingBurger();
        burger = burgerFactory.createBurger(type);
        if(burger!=null) {
            burger.prepare();
        }
    }
}
