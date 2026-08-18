package SOLID_Principles.DependencyInversionPrinciple;

/*
 * Dependency Inversion Principle: High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.
 * This principle helps to reduce the coupling between high-level and low-level modules, making the system more flexible and easier to maintain.
 */
interface Database{ //abstraction
    void save(String data);
}

class MySQLDatabase implements Database{ //low level module
    public void save(String data){
        System.out.println("Saving data to MySQL database: " + data);
    }
}

class MongoDBDatabase implements Database{ //low level module
    public void save(String data){
        System.out.println("Saving data to MongoDB database: " + data);
    }
}

//high level module
class UserService{ //loosely coupled
    private Database database;

    public UserService(Database database){
        this.database = database;
    }

    public void saveUser(String userData){
        database.save(userData);
    }
}

public class DIPFollowed {
    public static void main(String[] args) {
        Database mySQLDatabase = new MySQLDatabase();
        Database mongoDBDatabase = new MongoDBDatabase();

        UserService userService1 = new UserService(mySQLDatabase);
        UserService userService2 = new UserService(mongoDBDatabase);

        userService1.saveUser("User data for MySQL");
        userService2.saveUser("User data for MongoDB");
    }
}
