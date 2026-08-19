package Design_Patterns.Factory;

// provides an interface for creating families of related objects without specifying their concrete classes.

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

interface GarlicBread {
    void prepare();
}

class BasicGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Basic Garlic Bread");
    }
}
class CheeseGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Cheese Garlic Bread");
    }
}
class BasicWheatGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Basic Wheat Garlic Bread");
    }
}
class CheeseWheatGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Cheese Wheat Garlic Bread");
    }
}

interface FoodFactory {
    Burger createBurger(String type);
    GarlicBread createGarlicBread(String type);
}

class SingBurgerFactory implements FoodFactory {
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

    public GarlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicGarlicBread();
        } else if (type.equalsIgnoreCase("cheese")) {
            return new CheeseGarlicBread();
        } else {
            throw new IllegalArgumentException("Unknown garlic bread type");
        }
    }
}

class KingBurgerFactory implements FoodFactory {
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

    public GarlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatGarlicBread();
        } else if (type.equalsIgnoreCase("cheese")) {
            return new CheeseWheatGarlicBread();
        } else {
            throw new IllegalArgumentException("Unknown garlic bread type");
        }
    }
}



public class AbstractFactoryMethod {
    public static void main(String[] args) {
        String burgerType = "premium";
        String garlicBreadType = "cheese";

        FoodFactory foodFactory = new KingBurgerFactory();
        Burger burger = foodFactory.createBurger(burgerType);
        GarlicBread garlicBread = foodFactory.createGarlicBread(garlicBreadType);
        if (burger != null) {
            burger.prepare();
        }
        if (garlicBread != null) {
            garlicBread.prepare();
        }
    }
}
