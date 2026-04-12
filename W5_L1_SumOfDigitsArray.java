import java.util.Scanner;

public class W5_L1_SumOfDigitsArray {
    // Method to count digits in a non-negative integer.
    public static int countDigits(int number) {
        // Handle 0 as a single-digit number.
        if (number == 0) {
            return 1;
        }

        // Count digits by repeatedly dividing by 10.
        int digitCount = 0;
        int workingNumber = number;
        while (workingNumber > 0) {
            digitCount++;
            workingNumber /= 10;
        }

        return digitCount;
    }

    // Method to build a digits array from a non-negative integer.
    public static int[] buildDigitsArray(int number, int digitCount) {
        // Create result array with exact required size.
        int[] digits = new int[digitCount];

        // Fill from end to preserve original order.
        int workingNumber = number;
        for (int index = digitCount - 1; index >= 0; index--) {
            digits[index] = workingNumber % 10;
            workingNumber /= 10;
        }

        return digits;
    }

    // Method to compute sum of values in an integer array.
    public static int findArraySum(int[] values) {
        // Initialize sum accumulator.
        int total = 0;

        // Traverse the array using length property.
        for (int index = 0; index < values.length; index++) {
            total += values[index];
        }

        return total;
    }

    public static void main(String[] args) {
        // Create scanner for user input.
        Scanner scanner = new Scanner(System.in);

        // Read number from user.
        System.out.print("Enter a non-negative integer: ");
        if (!scanner.hasNextInt()) {
            // Validate numeric input.
            System.err.println("Invalid input. Please enter an integer value.");
            scanner.close();
            return;
        }

        // Store user input in variable.
        int inputNumber = scanner.nextInt();

        // Validate non-negative constraint.
        if (inputNumber < 0) {
            System.err.println("Invalid number. Number cannot be negative.");
            scanner.close();
            return;
        }

        // Compute count of digits.
        int digitCount = countDigits(inputNumber);

        // Build digits array.
        int[] digits = buildDigitsArray(inputNumber, digitCount);

        // Compute sum of digits.
        int digitSum = findArraySum(digits);

        // Display final result.
        System.out.println("Sum of digits: " + digitSum);

        // Close scanner resource.
        scanner.close();
    }
}
