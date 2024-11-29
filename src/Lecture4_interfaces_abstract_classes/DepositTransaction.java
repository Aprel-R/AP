package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(double amount, @NotNull Calendar date, String transactionID){
        super(amount, date, transactionID);
    } 

    /**
     * Checks if the deposit amount is valid (greater than or equal to zero).
     *
     * @param amt The deposit amount to check.
     * @return true if the amount is valid, false otherwise.
     */
    private boolean checkDepositAmount(double amt) {
        return amt >= 0;
    }

    /**
     * Prints the transaction details.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction:");
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
    }

    /**
     * Applies the deposit transaction to the given BankAccount.
     *
     * @param ba The BankAccount to apply the transaction on.
     */
    @Override
    public void apply(BankAccount ba) {
        if (checkDepositAmount(getAmount())) { // Method integrated here
            double curr_balance = ba.getBalance();
            double new_balance = curr_balance + getAmount();
            ba.setBalance(new_balance);
            System.out.println("Deposited " + getAmount() + " into the account. New balance: " + new_balance);
        } else {
            System.out.println("Invalid deposit amount: " + getAmount());
        }
    }

    // private boolean checkDepositAmount(int amt){
    //     if (amt < 0){
    //        return false;
    //     }
    //     else{
    //         return  true;
    //     }
    // }

    // // Method to print a transaction receipt or details
    // public void printTransactionDetails(){
    //     System.out.println("Deposit Trasaction: "+this.toString());
    // }

    // public void apply(BankAccount ba){
    //     double curr_balance = ba.getBalance();
    //     double new_balance = curr_balance + getAmount();
    //     ba.setBalance(new_balance);
    // }
}
