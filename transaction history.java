//store and display a history of transactions.
import java.util.ArrayList;
import java.util.List;

// Define an interface for account types
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    List<String> getTransactionHistory();
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
}

// Main class to demonstrate account management
public class AccountManagement {
    public static void main(String[] args) {
        // Create savings account
        Account savingsAccount = new SavingsAccount();
        savingsAccount.deposit(1000);
        savingsAccount.withdraw(200);

        // Create checking account
        Account checkingAccount = new CheckingAccount();
        checkingAccount.deposit(500);
        checkingAccount.withdraw(300);

        // Display balances
        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
        System.out.println("Checking Account Balance: " + checkingAccount.getBalance());

        // Display transaction history
        System.out.println("\nSavings Account Transaction History:");
        for (String transaction : savingsAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }

        System.out.println("\nChecking Account Transaction History:");
        for (String transaction : checkingAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}
