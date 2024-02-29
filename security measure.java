//Implement user authentication,PIN codes,and secure trnsactions
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String passwordHash;
    private String pin;

    public User(String username, String password, String pin) {
        this.username = username;
        this.passwordHash = hashPassword(password);
        this.pin = hashPin(pin);
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return passwordHash.equals(hashPassword(password));
    }

    public boolean verifyPIN(String enteredPIN) {
        return pin.equals(hashPin(enteredPIN));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String hashPin(String pin) {
        // Similar to hashPassword, implement hashing for PIN (e.g., SHA-256)
        return hashPassword(pin);
    }
}

class Transaction {
    public static boolean performTransaction(User user, double amount) {
        // Dummy transaction implementation
        System.out.println("Transaction performed: $" + amount);
        return true;
    }
}

public class SecureTransactionDemo {
    private static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        // Register users (in a real system, this data would come from a database)
        users.put("alice", new User("alice", "password123", "1234"));

        // Simulate login and transaction
        loginAndPerformTransaction("alice", "password123", "1234", 100.0);
    }

    private static void loginAndPerformTransaction(String username, String password, String pin, double amount) {
        Scanner scanner = new Scanner(System.in);
        User user = users.get(username);
        if (user != null && user.authenticate(password)) {
            System.out.println("Logged in successfully.");
            System.out.print("Enter your PIN: ");
            String enteredPIN = scanner.nextLine();
            if (user.verifyPIN(enteredPIN)) {
                System.out.println("PIN verified. Performing transaction...");
                Transaction.performTransaction(user, amount);
            } else {
                System.out.println("Incorrect PIN.");
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
