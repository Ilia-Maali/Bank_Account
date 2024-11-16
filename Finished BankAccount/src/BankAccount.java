class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative.");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Withdrawal amount cannot be negative.");
            }
            if (amount > this.balance) {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }
            this.balance -= amount;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public double checkBalance() {
        return balance;
    }
}
