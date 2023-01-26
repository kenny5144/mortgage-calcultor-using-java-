import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    private static final int MONTHS_IN_A_YEAR = 12;

    public static void main(String[] args) {

        final byte percent = 100;
        double principal;
        Scanner scanner = new Scanner(System.in);

       while (true){
            System.out.println("Enter the principal amount:");
            principal = scanner.nextDouble();
           if (principal < 1000 || principal > 1_000_000)
               System.out.println("Please enter a digit between 1 thousand and 1 million ");
           else
               break;

        };

        System.out.println("Enter the down-payment:");
        double downPayments = scanner.nextDouble();

        System.out.println("Enter the annual interest rate:");
        float annualInterestRate = scanner.nextFloat();

        System.out.println("Enter the term in years:");
        int termInYears = scanner.nextInt();

        scanner.close();

        double afterDownPayments= principal-downPayments;
        System.out.println(afterDownPayments);
        float monthlyInterestRate = annualInterestRate /percent/ MONTHS_IN_A_YEAR;
        int numberOfPayments = termInYears * MONTHS_IN_A_YEAR;

        double monthlyPayment = afterDownPayments * (
                (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))) /
                        ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1)
        );

        System.out.println("Monthly payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));

        System.out.println("Total payback amount: " + NumberFormat.getCurrencyInstance().format(monthlyPayment * numberOfPayments));

    }
}
