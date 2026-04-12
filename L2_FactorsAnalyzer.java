import java.util.Arrays;
import java.util.Scanner;

public class L2_FactorsAnalyzer {
    public static int[] findFactors(int number) {
        int factorCount = 0;

        for (int candidate = 1; candidate <= number; candidate++) {
            if (number % candidate == 0) {
                factorCount++;
            }
        }

        int[] factors = new int[factorCount];
        int currentIndex = 0;
        for (int candidate = 1; candidate <= number; candidate++) {
            if (number % candidate == 0) {
                factors[currentIndex] = candidate;
                currentIndex++;
            }
        }

        return factors;
    }

    public static int findSumOfFactors(int[] factors) {
        int factorSum = 0;
        for (int factor : factors) {
            factorSum += factor;
        }
        return factorSum;
    }

    public static long findProductOfFactors(int[] factors) {
        long factorProduct = 1L;
        for (int factor : factors) {
            factorProduct *= factor;
        }
        return factorProduct;
    }

    public static double findSumOfSquaresOfFactors(int[] factors) {
        double sumOfSquares = 0.0;
        for (int factor : factors) {
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int inputNumber = inputScanner.nextInt();

        if (inputNumber <= 0) {
            System.out.println("Please enter a positive integer greater than zero.");
            inputScanner.close();
            return;
        }

        int[] factors = findFactors(inputNumber);
        int sumOfFactors = findSumOfFactors(factors);
        long productOfFactors = findProductOfFactors(factors);
        double sumOfSquares = findSumOfSquaresOfFactors(factors);

        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Sum of factors: " + sumOfFactors);
        System.out.println("Product of factors: " + productOfFactors);
        System.out.println("Sum of squares of factors: " + sumOfSquares);

        inputScanner.close();
    }
}
