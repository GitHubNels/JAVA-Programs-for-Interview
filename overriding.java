// Method Overriding
// Consider a banking system where different types of accounts (savings, current) have different interest calculation methods.

class BankAccount {
    // Method to calculate interest
    public double calculateInterest(double balance) {
        return balance * 0.03; // 3% interest for general accounts
    }
}

class SavingsAccount extends BankAccount {
    // Overriding the calculateInterest method for savings account
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.04; // 4% interest for savings accounts
    }
}

class CurrentAccount extends BankAccount {
    // Overriding the calculateInterest method for current account
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.02; // 2% interest for current accounts
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount generalAccount = new BankAccount();
        BankAccount savingsAccount = new SavingsAccount();
        BankAccount currentAccount = new CurrentAccount();

        System.out.println("General Account Interest: " + generalAccount.calculateInterest(1000));
        System.out.println("Savings Account Interest: " + savingsAccount.calculateInterest(1000));
        System.out.println("Current Account Interest: " + currentAccount.calculateInterest(1000));
    }
}
