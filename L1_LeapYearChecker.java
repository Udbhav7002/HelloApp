import java.util.Scanner;

public class L1_LeapYearChecker {
    private static final int GREGORIAN_START_YEAR = 1582;
    private static final int DIVISIBLE_BY_4 = 4;
    private static final int DIVISIBLE_BY_100 = 100;
    private static final int DIVISIBLE_BY_400 = 400;

    public boolean isValidGregorianYear(int year) {
        return year >= GREGORIAN_START_YEAR;
    }

    public boolean isLeapYear(int year) {
        boolean divisibleBy4 = year % DIVISIBLE_BY_4 == 0;
        boolean notDivisibleBy100 = year % DIVISIBLE_BY_100 != 0;
        boolean divisibleBy400 = year % DIVISIBLE_BY_400 == 0;

        return (divisibleBy4 && notDivisibleBy100) || divisibleBy400;
    }

    public static void main(String[] args) {
        L1_LeapYearChecker leapYearChecker = new L1_LeapYearChecker();
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int inputYear = inputScanner.nextInt();

        if (!leapYearChecker.isValidGregorianYear(inputYear)) {
            System.out.println("Year must be >= " + GREGORIAN_START_YEAR + " for Gregorian calendar rules.");
        } else {
            boolean leapYearResult = leapYearChecker.isLeapYear(inputYear);
            System.out.println(inputYear + (leapYearResult ? " is a Leap Year." : " is NOT a Leap Year."));
        }

        inputScanner.close();
    }
}
