import java.io.*;

class BankAccount {
    private double balance;
    private static final String BALANCE_FILE = "balance.txt";

    public BankAccount() {
        this.balance = readBalanceFromFile();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        writeBalanceToFile();
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            writeBalanceToFile();
            return true;
        }
        return false;
    }

    private double readBalanceFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BALANCE_FILE))) {
            return Double.parseDouble(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            // If file doesn't exist or is empty/invalid, return default balance
            return 1000; // Default initial balance
        }
    }
}