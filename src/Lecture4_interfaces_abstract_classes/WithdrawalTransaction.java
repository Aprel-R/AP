package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private double originalBalance; // To store the balance before withdrawal
    
    public WithdrawalTransaction(double amount, @NotNull Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    /**
     * Method to apply the withdrawal transaction to the BankAccount.
     * Checks for sufficient funds and throws an exception if balance is insufficient.
     *
     * @param ba The BankAccount to apply the transaction on.
     * @throws InsufficientFundsException If the account balance is insufficient.
     */
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        originalBalance = ba.getBalance();
        if (originalBalance < getAmount()) {
            throw new InsufficientFundsException("Insufficient funds. Available: " + originalBalance + ", Requested: " + getAmount());
        }
        ba.withdraw(getAmount());
        System.out.println("Withdrew " + getAmount() + " from account. Remaining balance: " + ba.getBalance());
    }


    /**
     * Prints the transaction details.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction:");
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
    }

    // private boolean checkDepositAmount(int amt) {
    //     if (amt < 0) {
    //         return false;
    //     } else {
    //         return true;
    //     }
    // }

    // // Method to reverse the transaction
    // public boolean reverse() {
    //     return true;
    // } // return true if reversal was successful

    // // Method to print a transaction receipt or details
    // public void printTransactionDetails() {
    //     System.out.println("Deposit Trasaction: " + this.toString());
    // }

    // /*
    // Oportunity for assignment: implementing different form of withdrawal
    //  */
    // public void apply(BankAccount ba) {
    //     double curr_balance = ba.getBalance();
    //     if (curr_balance > getAmount()) {
    //         double new_balance = curr_balance - getAmount();
    //         ba.setBalance(new_balance);
    //     }
    // }

    /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     * Reverses the withdrawal transaction by restoring the original balance to the BankAccount.
     * @param ba The BankAccount to reverse the transaction on.
     * @return true if the reversal was successful, false otherwise.
     */
   public boolean reverse(BankAccount ba) {
        ba.deposit(getAmount());
        System.out.println("Reversed withdrawal of " + getAmount() + ". Balance restored to: " + ba.getBalance());
        return true;
    }
}

