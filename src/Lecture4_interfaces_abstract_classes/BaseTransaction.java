package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public abstract class BaseTransaction implements TransactionInterface {
    private final double amount;
    private final Calendar date;
    private final String transactionID;

    /**
     * Lecture1_adt.TransactionInterface Constructor
     * @param amount       The transaction amount (double).
     * @param date         The transaction date (not null, must be a Calendar object).
     * @param transactionID A unique identifier for the transaction.
     */

    public BaseTransaction(double amount, @NotNull Calendar date, String transactionID)  {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        this.transactionID = transactionID; // Unique transaction identifier
        // int uniq = (int) Math.random()*10000;
        // transactionID = date.toString()+uniq;
    }


    /**
     * Gets the transaction amount.
     *
     * @return The transaction amount.
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the transaction date.
     *
     * @return A copy of the transaction date.
     */
    @Override
    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    /**
     * Gets the unique transaction ID.
     *
     * @return The transaction ID.
     */
    @Override
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Prints the transaction details.
     * This method must be implemented by subclasses.
     */
    @Override
    public abstract void printTransactionDetails();

    /**
     * Applies the transaction to a given BankAccount.
     * This method must be implemented by subclasses.
     *
     * @param ba The BankAccount to apply the transaction on.
     */
    @Override
    public abstract void apply(BankAccount ba) throws InsufficientFundsException;

//     /**
//      * getAmount()
//      * @return integer
//      */
//     public double getAmount() {
//         return amount; // Because we are dealing with Value types we need not worry about what we return
//     }

//     /**
//      * getDate()
//      * @return Calendar Object
//      */
//     public Calendar getDate() {
// //        return date;    // Because we are dealing with Reference types we need to judiciously copy what our getters return
//         return (Calendar) date.clone(); // Defensive copying or Judicious Copying
//     }

//     // Method to get a unique identifier for the transaction
//     public String getTransactionID(){
//         return  transactionID;
//     }
//     // Method to print a transaction receipt or details
//     public abstract void printTransactionDetails();
//     public abstract void apply(BankAccount ba);
}
