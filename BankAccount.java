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
        if(amount > 0){
            balance += amount;
            writeBalanceToFile();
            System.out.println("Deposit successful");
       }else{
        System.out.println("Deposit amount must be positive");
    }
}

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }

        if (amount <= balance) {
            balance -= amount;
            writeBalanceToFile();
            System.out.println("Withdrawal successful");
            return true;
       }
        if (amount > balance){
            System.out.println("Insufficient balance");
            return false;
        }

        return false;
}

    private double readBalanceFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BALANCE_FILE))) {
            return Double.parseDouble(reader.readLine()); // Read and parse balance from file
            
        } catch (IOException | NumberFormatException e) {
            // If file doesn't exist or is empty/invalid, return default balance
            return 1000; // Default initial balance
        }
    }

    private void writeBalanceToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BALANCE_FILE))) {
            writer.write(String.valueOf(balance));
        } catch (IOException e) {
            System.out.println("Error saving balance: " + e.getMessage());
        }
    }
}