import java.util.Scanner;

public class W6_L2_ReverseDigitsArray {
    // Method to count digits of a non-negative number.
    public static int countDigits(long number) {
        // Handle zero as one digit.
        if (number == 0) {
            return 1;
        }

        // Count digits by dividing by 10.
        int count = 0;
        long workingNumber = number;
        while (workingNumber > 0) {
            count++;
            workingNumber /= 10;
        }

        return count;
    }

    // Method to store number digits in original order.
    public static int[] buildDigits(long number, int digitCount) {
        // Create target array.
        int[] digits = new int[digitCount];

        // Fill from right to left.
        long workingNumber = number;
        for (int index = digitCount - 1; index >= 0; index--) {
            digits[index] = (int) (workingNumber % 10);
            workingNumber /= 10;
        }

        return digits;
    }

    // Method to create reversed array from given array.
    public static int[] reverseArray(int[] values) {
        // Create reversed array with same size.
        int[] reversed = new int[values.length];

        // Copy elements in reverse order.
        for (int index = 0; index < values.length; index++) {
            reversed[index] = values[values.length - 1 - index];
        }

        return reversed;
    }

    // Method to print integer array.
    public static void printArray(int[] values) {
        // Print in bracketed form.
        System.out.print("[");
        for (int index = 0; index < values.length; index++) {
            System.out.print(values[index]);
            if (index < values.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Create scanner object.
        Scanner scanner = new Scanner(System.in);

        // Read and validate numeric input.
        System.out.print("Enter a non-negative number: ");
        if (!scanner.hasNextLong()) {
            System.err.println("Invalid input. Enter integer value.");
            scanner.close();
            return;
        }
        long inputNumber = scanner.nextLong();

        // Validate non-negative constraint.
        if (inputNumber < 0) {
            System.err.println("Number must be non-negative.");
            scanner.close();
            return;
        }

        // Compute digit count.
        int digitCount = countDigits(inputNumber);

        // Build digit array.
        int[] digits = buildDigits(inputNumber, digitCount);

        // Build reverse digit array.
        int[] reversedDigits = reverseArray(digits);

        // Display arrays.
        System.out.print("Digits: ");
        printArray(digits);
        System.out.print("Reversed digits: ");
        printArray(reversedDigits);

        // Close scanner resource.
        scanner.close();
    }
}
