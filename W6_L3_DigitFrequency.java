import java.util.Scanner;

public class W6_L3_DigitFrequency {
    private static final int DIGIT_COUNT = 10;

    // Method to count digits for non-negative numbers.
    public static int countDigits(long number) {
        // Handle zero case.
        if (number == 0) {
            return 1;
        }

        // Count using repeated division.
        int count = 0;
        long workingNumber = number;
        while (workingNumber > 0) {
            count++;
            workingNumber /= 10;
        }

        return count;
    }

    // Method to store digits into array.
    public static int[] getDigits(long number, int digitCount) {
        // Allocate digits array.
        int[] digits = new int[digitCount];

        // Fill array from right to left.
        long workingNumber = number;
        for (int index = digitCount - 1; index >= 0; index--) {
            digits[index] = (int) (workingNumber % DIGIT_COUNT);
            workingNumber /= DIGIT_COUNT;
        }

        return digits;
    }

    // Method to find frequency for each digit 0-9.
    public static int[] findFrequency(int[] digits) {
        // Allocate frequency array.
        int[] frequency = new int[DIGIT_COUNT];

        // Increase count for each observed digit.
        for (int index = 0; index < digits.length; index++) {
            int digit = digits[index];
            frequency[digit]++;
        }

        return frequency;
    }

    public static void main(String[] args) {
        // Create scanner object.
        Scanner scanner = new Scanner(System.in);

        // Read and validate integer input.
        System.out.print("Enter a non-negative number: ");
        if (!scanner.hasNextLong()) {
            System.err.println("Invalid input. Enter integer value.");
            scanner.close();
            return;
        }
        long inputNumber = scanner.nextLong();

        // Validate non-negative value.
        if (inputNumber < 0) {
            System.err.println("Number must be non-negative.");
            scanner.close();
            return;
        }

        // Count digits and store into array.
        int digitCount = countDigits(inputNumber);
        int[] digits = getDigits(inputNumber, digitCount);

        // Compute frequency table.
        int[] frequency = findFrequency(digits);

        // Display frequency output.
        System.out.println("Digit frequency:");
        for (int digit = 0; digit < frequency.length; digit++) {
            System.out.println(digit + " -> " + frequency[digit]);
        }

        // Close scanner resource.
        scanner.close();
    }
}
