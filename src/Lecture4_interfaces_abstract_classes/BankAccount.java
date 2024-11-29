package Lecture4_interfaces_abstract_classes;

public class BankAccount {
    private double balance;

    /**
     * Constructor to initialize the bank account with a starting balance.
     *
     * @param balance The initial balance of the account.
     */
    public BankAccount(double balance) {
        this.balance = balance;
    }

    /**
     * Gets the current balance of the account.
     *
     * @return The current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the account.
     *
     * @param balance The new balance to set.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Deposits an amount into the account.
     *
     * @param amount The amount to deposit.
     * @throws IllegalArgumentException If the deposit amount is negative.
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount must be non-negative.");
        }
        balance += amount;
    }

    /**
     * Withdraws an amount from the account.
     *
     * @param amount The amount to withdraw.
     * @throws IllegalArgumentException If the withdrawal amount is negative.
     * @throws InsufficientFundsException If the withdrawal amount exceeds the account balance.
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount must be non-negative.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Available balance: " + balance);
        }
        balance -= amount;
    }
}
