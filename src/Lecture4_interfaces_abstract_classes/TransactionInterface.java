package Lecture4_interfaces_abstract_classes;
import java.util.Calendar;

/**
 * Interface for Transactions
 * Any class that defines a transaction is expected to implement this Interface
 * This interface supports methods for retrieving transaction details and applying them to a BankAccount.
 */

public interface TransactionInterface {
    double getAmount();
    Calendar getDate();
    String getTransactionID();
    void printTransactionDetails();

    void apply(BankAccount ba) throws InsufficientFundsException;
}
