import java.io.*;

class BankAccount {
    private double balance;
    private static final String BALANCE_FILE = "balance.txt";

    public BankAccount() {
        this.balance = readBalanceFromFile();
    }
}