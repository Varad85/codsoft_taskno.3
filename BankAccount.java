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
}