public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount();
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}

