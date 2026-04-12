import java.util.Scanner;

public class W5_L1_DigitFrequencyArray {
    private static final int DIGIT_BASE = 10;

    // Method to count digits in a non-negative number.
    public static int countDigits(int number) {
        // Handle zero as one digit.
        if (number == 0) {
            return 1;
        }

        // Count digits by dividing number by 10.
        int count = 0;
        int workingNumber = number;
        while (workingNumber > 0) {
            count++;
            workingNumber /= 10;
        }

        return count;
    }

    // Method to save digits of the number into an array.
    public static int[] extractDigits(int number, int digitCount) {
        // Create fixed-size digit array.
        int[] digits = new int[digitCount];

        // Fill digits from end to beginning.
        int workingNumber = number;
        for (int index = digitCount - 1; index >= 0; index--) {
            digits[index] = workingNumber % DIGIT_BASE;
            workingNumber /= DIGIT_BASE;
        }

        return digits;
    }

    // Method to compute frequency of each digit from 0 to 9.
    public static int[] findDigitFrequencies(int[] digits) {
        // Create frequency array for digits 0-9.
        int[] frequencies = new int[DIGIT_BASE];

        // Count each digit occurrence.
        for (int index = 0; index < digits.length; index++) {
            int currentDigit = digits[index];
            frequencies[currentDigit]++;
        }

        return frequencies;
    }

    // Method to display frequency table.
    public static void printFrequencies(int[] frequencies) {
        // Print all digits and their counts.
        for (int digit = 0; digit < frequencies.length; digit++) {
            System.out.println(digit + " -> " + frequencies[digit]);
        }
    }

    public static void main(String[] args) {
        // Create scanner for user input.
        Scanner scanner = new Scanner(System.in);

        // Read integer input and validate type.
        System.out.print("Enter a non-negative integer: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Please enter an integer.");
            scanner.close();
            return;
        }

        // Store user-provided number.
        int inputNumber = scanner.nextInt();

        // Validate non-negative condition.
        if (inputNumber < 0) {
            System.err.println("Invalid number. Number cannot be negative.");
            scanner.close();
            return;
        }

        // Count number of digits.
        int digitCount = countDigits(inputNumber);

        // Extract all digits into array.
        int[] digits = extractDigits(inputNumber, digitCount);

        // Compute frequency for each digit.
        int[] frequencies = findDigitFrequencies(digits);

        // Display frequency result.
        System.out.println("Digit frequency table:");
        printFrequencies(frequencies);

        // Close scanner resource.
        scanner.close();
    }
}
