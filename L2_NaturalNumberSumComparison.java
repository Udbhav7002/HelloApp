import java.util.Scanner;

public class L2_NaturalNumberSumComparison {
    public static boolean isNaturalNumber(int number) {
        return number > 0;
    }

    public static int findSumUsingRecursion(int number) {
        if (number == 1) {
            return 1;
        }
        return number + findSumUsingRecursion(number - 1);
    }

    public static int findSumUsingFormula(int number) {
        return number * (number + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int inputNumber = inputScanner.nextInt();

        if (!isNaturalNumber(inputNumber)) {
            System.out.println("Input must be a natural number greater than 0.");
            inputScanner.close();
            return;
        }

        int recursiveSum = findSumUsingRecursion(inputNumber);
        int formulaSum = findSumUsingFormula(inputNumber);
        boolean resultsMatch = recursiveSum == formulaSum;

        System.out.println("Recursive sum: " + recursiveSum);
        System.out.println("Formula sum: " + formulaSum);
        System.out.println("Both results are " + (resultsMatch ? "correct and equal." : "NOT equal."));

        inputScanner.close();
    }
}
