// import Lecture1_adt.*; // Import all classes from Lecture1_adt package to be used in this client code
import Lecture4_interfaces_abstract_classes.BankAccount;
import Lecture4_interfaces_abstract_classes.BaseTransaction;
import Lecture4_interfaces_abstract_classes.WithdrawalTransaction;
import Lecture4_interfaces_abstract_classes.InsufficientFundsException;
import Lecture4_interfaces_abstract_classes.DepositTransaction;

import java.util.Calendar;
import java.util.GregorianCalendar;
// import java.util.ArrayList;
// import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
* Client Code for accessing the Lecture1_adt.TransactionInterface.java module
 */
public class Main {

    /**
     * Tests the DepositTransaction functionality.
     */
    public static void testDepositTransaction() {
        BankAccount account = new BankAccount(500.0);
        Calendar date = new GregorianCalendar(2024, Calendar.DECEMBER, 1);
        DepositTransaction deposit = new DepositTransaction(200.0, date, "DEP001");

        System.out.println("\nTesting DepositTransaction:");
        deposit.apply(account);
        deposit.printTransactionDetails();
        System.out.println("New account balance: " + account.getBalance());
    }

    /**
     * Tests the WithdrawalTransaction functionality, including exception handling.
     */
    public static void testWithdrawalTransaction() {
        BankAccount account = new BankAccount(500.0);
        Calendar date = new GregorianCalendar(2024, Calendar.DECEMBER, 1);
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(400.0, date, "WTH001");

        System.out.println("\nTesting WithdrawalTransaction:");
        try {
            withdrawal.apply(account);
            withdrawal.printTransactionDetails();
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
        System.out.println("Account balance after withdrawal attempt: " + account.getBalance());
    }

    /**
     * Tests the reverse method of WithdrawalTransaction.
     */
    public static void testReverseTransaction() {
        BankAccount account = new BankAccount(700.0);
        Calendar date = new GregorianCalendar(2024, Calendar.DECEMBER, 1);
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(200.0, date, "WTH002");

        System.out.println("\nTesting Reversal of WithdrawalTransaction:");
        try {
            withdrawal.apply(account);
            System.out.println("Balance after withdrawal: " + account.getBalance());
            boolean reversed = withdrawal.reverse(account);
            System.out.println("Reversal successful: " + reversed);
            System.out.println("Balance after reversal: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }

    /**
     * Demonstrates polymorphism with BaseTransaction references.
     */
    public static void testPolymorphism() {
        BankAccount account = new BankAccount(700.0);
        Calendar date = new GregorianCalendar(2024, Calendar.DECEMBER, 1);

        BaseTransaction deposit = new DepositTransaction(100.0, date, "DEP002");
        BaseTransaction withdrawal = new WithdrawalTransaction(50.0, date, "WTH003");

        System.out.println("\nTesting Polymorphism with BaseTransaction:");

        try {
            deposit.apply(account);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
        
        deposit.printTransactionDetails();
        System.out.println("Balance after deposit: " + account.getBalance());

        try {
            withdrawal.apply(account);
            withdrawal.printTransactionDetails();
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }

    // public static void testTransaction1() {
    //     Calendar d1 = new GregorianCalendar(); // d1 is an Object [Objects are Reference types]
    //     Lecture1_adt.Transaction1 t1 = new Lecture1_adt.Transaction1(1000, d1); // amount and d1 are arguments

    //     System.out.println(t1.toString());
    //     System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + t1.amount);
    //     System.out.println("Lecture1_adt.TransactionInterface Date: \t " + t1.date);

    //     // Please note that the Client Codes can access the data in the class directly through the dot operator
    //     // This kind of exposure is a threat to both the Representation Independence and Preservation of Invariants
    // }


    // /** @return a transaction of same amount as t, one month later
    //  * This is a PRODUCER of the class Lecture1_adt.Transaction2
    //  * This code will help demostrate the Design exposures still present in transaction2 class
    //  * */

    // public static Transaction2 makeNextPayment(Transaction2 t) {
    //     Calendar d =  t.getDate();
    //     d.add(Calendar.MONTH, 1);
    //     return new Transaction2(t.getAmount(), d);
    // }

    // /*
    // Testing Transaction2 class
    //  */
    // public static void testTransaction2() {

    //     Calendar d1 = new GregorianCalendar();

    //     Lecture1_adt.Transaction2 t = new Lecture1_adt.Transaction2(1000, d1);

    //     Lecture1_adt.Transaction2 modified_t = makeNextPayment(t);

    //     System.out.println("\n\nState of the Object T1 After Client Code Tried to Change the Amount");
    //     System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+modified_t.getAmount());
    //     System.out.println("Lecture1_adt.TransactionInterface Date: \t "+modified_t.getDate().getTime());

    //     System.out.println("\n\nHow does T2 Look Like?????");
    //     System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+modified_t.getAmount());
    //     System.out.println("Lecture1_adt.TransactionInterface Date: \t "+modified_t.getDate().getTime());

    //     /* Please note that Although we have solved the problem of Transaction1
    //     * And client code can no longer use the dot (.) operator to directly access the data
    //     * There is still some exposure especially if we pass an object of a previous Transaction2 to create a new Transaction2 object
    //      */

    // }


    // /** @return a list of 12 monthly payments of identical amounts
    //  * This code will help demostrate the Design exposures still present in transaction3 class
    //  * */
    // public static List<Transaction3> makeYearOfPayments (int amount) throws NullPointerException {

    //     List<Transaction3> listOfTransaction3s = new ArrayList<Transaction3>();
    //     Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);


    //     for (int i = 0; i < 12; i++) {
    //         listOfTransaction3s.add(new Transaction3(amount, date));
    //         date.add(Calendar.MONTH, 1);
    //     }
    //     return listOfTransaction3s;
    // }

    // /*
    // Testing Transaction3 class
    //  */
    // public static void testTransaction3() {

    //     List<Transaction3> allPaymentsIn2024 = makeYearOfPayments(1000);

    //     for (Transaction3 t3 : allPaymentsIn2024) {

    //         // Display all the 12 Transactions
    //         for (Transaction3 transact : allPaymentsIn2024) {
    //             System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
    //             System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+transact.getAmount());
    //             System.out.println("Lecture1_adt.TransactionInterface Date: \t "+transact.getDate().getTime());
    //         }
    //     }

    //     /* Please Check all the 12 transactions displayed and hwo their dates look like
    //      * Note that Although Transaction3 class resolves to an extent the exposure in Transaction2 class
    //      * There is still some exposure especially if we pass an object of a previous Transaction3 to create a
    //      * new Transaction3 object
    //      */
    // }


    // /** @return a list of 12 monthly payments of identical amounts
    //  * This code Show that by judicious copying and defensive programming we eliminate the exposure in Transaction3
    //  * As defined in the constructor of Transaction4 class
    //  * */

    // public static List<Transaction4> makeYearOfPaymentsFinal (int amount) throws NullPointerException {

    //     List<Transaction4> listOfTransaction4s = new ArrayList<Transaction4>();
    //     Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);


    //     for (int i = 0; i < 12; i++) {
    //         listOfTransaction4s.add(new Transaction4(amount, date));
    //         date.add(Calendar.MONTH, 1);
    //     }
    //     return listOfTransaction4s;
    // }

    // /*
    // Testing Transaction3 class
    //  */
    // public static void testTransaction4() {

    //     /*
    //      * Call the function to make all the Twelve transaction in a year of our business
    //      */

    //     List<Transaction4> transactionsIn2024 = makeYearOfPaymentsFinal(1200);

    //     // Display all the 12 Transactions
    //     for (Transaction4 transact : transactionsIn2024) {
    //         System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
    //         System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+transact.getAmount());
    //         System.out.println("Lecture1_adt.TransactionInterface Date: \t "+transact.getDate().getTime());
    //     }

    //     // Please Take a look at all the 12 transaction now and compare with the outputs of the Transaction3 class
    // }


    public static void main(String[] args) {
        // This is the client code
        // Uncomment the following lines to test the class which you would like to test

        // testTransaction1()
        // testTransaction2()
        // testTransaction3()
        // testTransaction4()

        // Test DepositTransaction
        testDepositTransaction();

        // Test WithdrawalTransaction
        testWithdrawalTransaction();

        // Test Reversal of WithdrawalTransaction
        testReverseTransaction();

        // Test Polymorphism with BaseTransaction
        testPolymorphism();
    }
}