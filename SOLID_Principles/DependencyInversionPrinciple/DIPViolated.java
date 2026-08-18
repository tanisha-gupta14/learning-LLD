package SOLID_Principles.DependencyInversionPrinciple;

class MySQLDatabase{ //low level module
    public void saveToSQL(String data){
        System.out.println("Saving data to MySQL database: " + data);
    }
}

class MongoDBDatabase{ //low level module
    public void saveToMongo(String data){
        System.out.println("Saving data to MongoDB database: " + data);
    }
}

//high level module
class UserService{ //tightly coupled
    private MySQLDatabase mySQLDatabase= new MySQLDatabase();
    private MongoDBDatabase mongoDBDatabase= new MongoDBDatabase();

    public void saveUserToMySQL(String userData){
        mySQLDatabase.saveToSQL(userData);
    }

    public void saveUserToMongo(String userData){
        mongoDBDatabase.saveToMongo(userData);
    }
}
public class DIPViolated {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.saveUserToMySQL("User data for MySQL");
        userService.saveUserToMongo("User data for MongoDB");
    }
}
