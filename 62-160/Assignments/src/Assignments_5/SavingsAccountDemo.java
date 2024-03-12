package Assignments_5;

import java.util.Scanner;

public class SavingsAccountDemo {

    public static void main(String[] args) {

        // Scanner method
        Scanner scanner = new Scanner(System.in);

        //int variable
        int userNumberOfMonths;

        // double variables
        double userAnnualInterestRate=0;
        double userStartingBalance=0;
        double depositAmount=0;
        double withdrawAmount=0;
        double totalDeposits = 0;
        double totalWithdrawals = 0;
        double totalInterestEarned = 0;

        // User enter starting balance
        System.out.print("Enter the savings account's starting balance:  ");
        userStartingBalance = scanner.nextDouble();

        // User enter annual interest
        System.out.print("Enter the savings account's annual interest rate: ");
        userAnnualInterestRate = scanner.nextDouble();

        // User enter how many months have passed since the account was opened
        System.out.print("How many months have passed since the account was opened? ");
        userNumberOfMonths = scanner.nextInt();

        // call to savingaccount method
        SavingAccount account = new SavingAccount(userStartingBalance);
        account.setAnnualInterestRate(userAnnualInterestRate);

        // for loop for enter the deposit amount and withdrawals amount
        for (int currentMonth = 1; currentMonth <= userNumberOfMonths; currentMonth++ ){

            // User enter deposit amount
            System.out.print("How much did you deposit month " + currentMonth + ": ");
            depositAmount = scanner.nextInt();
            totalDeposits +=  depositAmount;
            account.deposit(depositAmount);

            // User enter withdraw Amount
            System.out.print("How much did you withdraw during month " + currentMonth + ": ");
            withdrawAmount = scanner.nextDouble();
            totalWithdrawals += withdrawAmount;
            account.withdraw(withdrawAmount);
            totalInterestEarned += account.addMonthlyInterest();
        }

        // final print account balance end of the months, total amount of deposits, total amount of withdrawals, total amount interest earned
        System.out.printf("The final balance at the end of %d months is $%,.2f\nThe total amount of deposits: $%,.2f\n" +
                            "The total amount of withdrawals: $%,.2f\nThe total interest earned: $%,.2f",userNumberOfMonths,
                        account.getBalance(),totalDeposits,totalWithdrawals,totalInterestEarned);

        // Exit Program
        System.exit(0);
    }
}
