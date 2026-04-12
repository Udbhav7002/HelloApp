import java.util.Scanner;

public class L1_NumberSignParityComparator {
    private static final int TOTAL_NUMBERS = 5;

    public boolean isPositive(int number) {
        return number > 0;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public int compareNumbers(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            return 1;
        }
        if (firstNumber == secondNumber) {
            return 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        L1_NumberSignParityComparator analyzer = new L1_NumberSignParityComparator();
        Scanner inputScanner = new Scanner(System.in);
        int[] numbers = new int[TOTAL_NUMBERS];

        for (int index = 0; index < TOTAL_NUMBERS; index++) {
            System.out.print("Enter number " + (index + 1) + ": ");
            numbers[index] = inputScanner.nextInt();
        }

        System.out.println("\nNumber Classification:");
        for (int number : numbers) {
            if (analyzer.isPositive(number)) {
                String parityLabel = analyzer.isEven(number) ? "Positive Even" : "Positive Odd";
                System.out.println(number + " -> " + parityLabel);
            } else {
                System.out.println(number + " -> Negative or Zero");
            }
        }

        int comparisonResult = analyzer.compareNumbers(numbers[0], numbers[TOTAL_NUMBERS - 1]);
        if (comparisonResult == 1) {
            System.out.println("\nFirst element is greater than last element.");
        } else if (comparisonResult == 0) {
            System.out.println("\nFirst element is equal to last element.");
        } else {
            System.out.println("\nFirst element is less than last element.");
        }

        inputScanner.close();
    }
}
