import java.util.Arrays;
import java.util.Scanner;

public class W8_L1_FactorsTask {
    public static int[] findFactorsArray(int number) {
        int factorCount = 0;

        for (int candidate = 1; candidate <= number; candidate++) {
            if (number % candidate == 0) {
                factorCount++;
            }
        }

        int[] factors = new int[factorCount];
        int index = 0;
        for (int candidate = 1; candidate <= number; candidate++) {
            if (number % candidate == 0) {
                factors[index] = candidate;
                index++;
            }
        }

        return factors;
    }

    public static int findGreatestFactor(int[] factors) {
        return factors[factors.length - 1];
    }

    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long findProductOfFactors(int[] factors) {
        long product = 1L;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double findProductOfFactorCubes(int[] factors) {
        double cubeProduct = 1.0;
        for (int factor : factors) {
            cubeProduct *= Math.pow(factor, 3);
        }
        return cubeProduct;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int inputNumber = scanner.nextInt();

        if (inputNumber <= 0) {
            System.out.println("Input must be greater than zero.");
            scanner.close();
            return;
        }

        int[] factors = findFactorsArray(inputNumber);
        int greatestFactor = findGreatestFactor(factors);
        int factorSum = findSumOfFactors(factors);
        long factorProduct = findProductOfFactors(factors);
        double factorCubeProduct = findProductOfFactorCubes(factors);

        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest Factor: " + greatestFactor);
        System.out.println("Sum of Factors: " + factorSum);
        System.out.println("Product of Factors: " + factorProduct);
        System.out.println("Product of Cube of Factors: " + factorCubeProduct);

        scanner.close();
    }
}
