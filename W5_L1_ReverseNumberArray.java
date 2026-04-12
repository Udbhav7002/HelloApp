import java.util.Scanner;

public class W5_L1_ReverseNumberArray {
    // Method to count digits in a non-negative integer.
    public static int countDigits(int number) {
        // Handle zero as one digit.
        if (number == 0) {
            return 1;
        }

        // Count digits through integer division.
        int count = 0;
        int workingNumber = number;
        while (workingNumber > 0) {
            count++;
            workingNumber /= 10;
        }
        return count;
    }

    // Method to extract digits in original order.
    public static int[] getDigits(int number, int count) {
        // Create digits array.
        int[] digits = new int[count];

        // Fill from end to start.
        int workingNumber = number;
        for (int index = count - 1; index >= 0; index--) {
            digits[index] = workingNumber % 10;
            workingNumber /= 10;
        }

        return digits;
    }

    // Method to reverse an integer array.
    public static int[] reverseArray(int[] values) {
        // Create result array of equal size.
        int[] reversed = new int[values.length];

        // Fill reversed array using length property.
        for (int index = 0; index < values.length; index++) {
            reversed[index] = values[values.length - 1 - index];
        }

        return reversed;
    }

    // Method to print array in a compact format.
    public static void printArray(int[] values) {
        // Open bracket for array display.
        System.out.print("[");

        // Print all values separated by comma.
        for (int index = 0; index < values.length; index++) {
            System.out.print(values[index]);
            if (index < values.length - 1) {
                System.out.print(", ");
            }
        }

        // Close bracket for array display.
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Create scanner object.
        Scanner scanner = new Scanner(System.in);

        // Take number input and validate type.
        System.out.print("Enter a non-negative integer: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Please enter an integer.");
            scanner.close();
            return;
        }

        // Store the validated integer input.
        int inputNumber = scanner.nextInt();

        // Validate range for negative values.
        if (inputNumber < 0) {
            System.err.println("Invalid number. Number cannot be negative.");
            scanner.close();
            return;
        }

        // Compute digit count.
        int digitCount = countDigits(inputNumber);

        // Build digits array.
        int[] digits = getDigits(inputNumber, digitCount);

        // Build reversed digits array.
        int[] reversedDigits = reverseArray(digits);

        // Display original and reversed digits.
        System.out.print("Original digits: ");
        printArray(digits);
        System.out.print("Reversed digits: ");
        printArray(reversedDigits);

        // Close scanner.
        scanner.close();
    }
}
