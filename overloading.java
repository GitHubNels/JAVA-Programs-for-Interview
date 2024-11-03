// Real-Time Example
// Method Overloading
// Consider a payment processing system where you need to process payments using different methods (credit card, debit card, and net banking).

class PaymentProcessor {
    // Method to process credit card payment
    public void processPayment(String creditCardNumber, double amount) {
        System.out.println("Processing credit card payment of " + amount);
    }

    // Overloaded method to process debit card payment
    public void processPayment(String debitCardNumber, String pin, double amount) {
        System.out.println("Processing debit card payment of " + amount);
    }

    // Overloaded method to process net banking payment
    public void processPayment(String bankAccountNumber, String ifscCode, double amount) {
        System.out.println("Processing net banking payment of " + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment("1234-5678-9012-3456", 100.0);
        processor.processPayment("9876-5432-1098-7654", "1234", 200.0);
        processor.processPayment("1234567890", "IFSC0001", 300.0);
    }
}
