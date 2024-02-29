//transfer funds between accounts
import java.util.ArrayList;
import java.util.List;

// Define an interface for account types
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    List<String> getTransactionHistory();
    void transfer(Account recipient, double amount);
}

// Implement Savings Account class
class SavingsAccount implements Account {
    private double balance;
    private List<String> transactionHistory;

    public SavingsAccount() {
        transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: +" + amount);
        System.out.println(amount + " deposited into savings account.");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -" + amount);
            System.out.println(amount + " withdrawn from savings account.");
        } else {
            System.out.println("Insufficient funds in savings account.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void transfer(Account recipient, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            recipient.deposit(amount);
            System.out.println(amount + " transferred from savings account to another account.");
        } else {
            System.out.println("Insufficient funds in savings account for transfer.");
        }
    }
}

// Implement Checking Account class
class CheckingAccount implements Account {
    private double balance;
    private List<String> transactionHistory;

    public CheckingAccount() {
        transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: +" + amount);
        System.out.println(amount + " deposited into checking account.");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -" + amount);
            System.out.println(amount + " withdrawn from checking account.");
        } else {
            System.out.println("Insufficient funds in checking account.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void transfer(Account recipient, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            recipient.deposit(amount);
            System.out.println(amount + " transferred from checking account to another account.");
        } else {
            System.out.println("Insufficient funds in checking account for transfer.");
        }
    }
}

// Main class to demonstrate account management
public class AccountManagement {
    public static void main(String[] args) {
        // Create savings account
        Account savingsAccount = new SavingsAccount();
        savingsAccount.deposit(1000);

        // Create checking account
        Account checkingAccount = new CheckingAccount();
        checkingAccount.deposit(500);

        // Transfer funds from savings to checking
        savingsAccount.transfer(checkingAccount, 200);

        // Display balances
        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
        System.out.println("Checking Account Balance: " + checkingAccount.getBalance());
    }
}
