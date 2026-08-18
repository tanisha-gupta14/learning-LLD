package SOLID_Principles.LiskovSubstitutionPrinciple;
import java.util.*;

interface Account{
    void deposit(double amount);
    void withdraw(double amount);
}

class SavingsAccount implements Account{
    private double balance;
    public SavingsAccount(double balance){
        this.balance = balance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("Remaining balance: $" + balance);
        }
        else{
            System.out.println("Insufficient balance.");
        }
    }
}
class FixedDepositAccount implements Account{
    private double balance;
    public FixedDepositAccount(double balance){
        this.balance = balance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        // This method violates the Liskov Substitution Principle because it does not allow withdrawals, which is expected behavior for an Account.
        throw new UnsupportedOperationException("Withdrawals are not allowed from a fixed deposit account.");
    }
}

class BankClient{
    private List<Account> accounts;
    public BankClient(List<Account> accounts){
        this.accounts = accounts;
    }
    public void processTransactions(){
        for(Account account: accounts){
            account.deposit(100);
            try{
                account.withdraw(50);
            }
            catch(UnsupportedOperationException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
public class LSPViolated {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount(200));
        accounts.add(new FixedDepositAccount(500));
        BankClient client = new BankClient(accounts);
        client.processTransactions();
    }
}
