import java.util.Scanner;

public class W6_L1_SumOfDigitsValidated {
    // Method to count number of digits in input value.
    public static int countDigits(int number) {
        // Handle zero as one digit.
        if (number == 0) {
            return 1;
        }

        // Count digits using repeated division.
        int count = 0;
        int workingNumber = number;
        while (workingNumber > 0) {
            count++;
            workingNumber /= 10;
        }

        return count;
    }

    // Method to convert number into digit array.
    public static int[] extractDigits(int number, int digitCount) {
        // Declare digit array.
        int[] digits = new int[digitCount];

        // Fill array from end to keep number order.
        int workingNumber = number;
        for (int index = digitCount - 1; index >= 0; index--) {
            digits[index] = workingNumber % 10;
            workingNumber /= 10;
        }

        return digits;
    }

    // Method to sum all digits from array.
    public static int sumDigits(int[] digits) {
        // Initialize sum variable.
        int sum = 0;

        // Traverse with length property.
        for (int index = 0; index < digits.length; index++) {
            sum += digits[index];
        }

        return sum;
    }

    public static void main(String[] args) {
        // Create scanner object.
        Scanner scanner = new Scanner(System.in);

        // Read and validate integer input.
        System.out.print("Enter a non-negative integer: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Please provide an integer.");
            scanner.close();
            return;
        }

        // Save user input.
        int inputNumber = scanner.nextInt();

        // Validate non-negative number.
        if (inputNumber < 0) {
            System.err.println("Invalid number. Number must be non-negative.");
            scanner.close();
            return;
        }

        // Count digits.
        int digitCount = countDigits(inputNumber);

        // Build digits array.
        int[] digits = extractDigits(inputNumber, digitCount);

        // Find digit sum.
        int sum = sumDigits(digits);

        // Display output.
        System.out.println("Sum of digits: " + sum);

        // Close scanner resource.
        scanner.close();
    }
}
