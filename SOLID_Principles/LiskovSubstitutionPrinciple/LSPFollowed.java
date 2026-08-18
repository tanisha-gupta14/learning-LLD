package SOLID_Principles.LiskovSubstitutionPrinciple;
import java.util.*;

/*
 * Liskov Substitution Principle: Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. In other words, subclasses should be able to extend the functionality of a superclass without changing its behavior.
 * Subclass should be substitutable for their base class.
 * 
 */

interface DepositOnlyAccount{
    void deposit(double amount);
}
interface WithdrawableAccount extends DepositOnlyAccount{
    void withdraw(double amount);
}

class SavingsAccount implements WithdrawableAccount{
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

class FixedDepositAccount implements DepositOnlyAccount{
    private double balance;
    public FixedDepositAccount(double balance){
        this.balance = balance;
    }
    public void deposit(double amount){
        balance += amount;
    }
}
class BankClient{
    private List<WithdrawableAccount> withdrawableAccounts;
    private List<DepositOnlyAccount> depositOnlyAccounts;
    public BankClient(List<WithdrawableAccount> withdrawableAccounts, List<DepositOnlyAccount> depositOnlyAccounts){
        this.withdrawableAccounts = withdrawableAccounts;
        this.depositOnlyAccounts = depositOnlyAccounts;
    }
    public void processTransactions(){
        for(WithdrawableAccount account: withdrawableAccounts){
            account.deposit(100);
            account.withdraw(50);
        }
        for(DepositOnlyAccount account: depositOnlyAccounts){
            account.deposit(100);
        }
    }
}
public class LSPFollowed {
    public static void main(String[] args) {
        List<WithdrawableAccount> withdrawableAccounts = new ArrayList<>();
        withdrawableAccounts.add(new SavingsAccount(200));
        
        List<DepositOnlyAccount> depositOnlyAccounts = new ArrayList<>();
        depositOnlyAccounts.add(new FixedDepositAccount(500));
        
        BankClient client = new BankClient(withdrawableAccounts, depositOnlyAccounts);
        client.processTransactions();
    }
    
}
