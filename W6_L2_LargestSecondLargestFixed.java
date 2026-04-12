import java.util.Scanner;

public class W6_L2_LargestSecondLargestFixed {
    private static final int MAX_DIGITS = 10;

    // Method to read digits into fixed-size array.
    public static int[] readDigitsIntoFixedArray(long number) {
        // Declare fixed-size digit array.
        int[] digits = new int[MAX_DIGITS];

        // Fill digit array until number ends or array fills.
        int index = 0;
        long workingNumber = number;
        while (workingNumber != 0 && index < digits.length) {
            digits[index] = (int) (workingNumber % 10);
            workingNumber /= 10;
            index++;
        }

        return digits;
    }

    // Method to find largest and second largest values in array.
    public static int[] findLargestAndSecondLargest(int[] digits) {
        // Initialize result variables.
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Traverse array to compute top two values.
        for (int index = 0; index < digits.length; index++) {
            int current = digits[index];
            if (current > largest) {
                secondLargest = largest;
                largest = current;
            } else if (current > secondLargest && current != largest) {
                secondLargest = current;
            }
        }

        return new int[]{largest, secondLargest};
    }

    public static void main(String[] args) {
        // Create scanner for user input.
        Scanner scanner = new Scanner(System.in);

        // Read and validate non-negative number.
        System.out.print("Enter a non-negative number: ");
        if (!scanner.hasNextLong()) {
            System.err.println("Invalid input. Enter an integer number.");
            scanner.close();
            return;
        }
        long inputNumber = scanner.nextLong();

        // Validate number range.
        if (inputNumber < 0) {
            System.err.println("Number must be non-negative.");
            scanner.close();
            return;
        }

        // Handle zero as special input.
        if (inputNumber == 0) {
            System.out.println("Largest digit: 0");
            System.out.println("Second largest digit: 0");
            scanner.close();
            return;
        }

        // Extract digits with fixed capacity.
        int[] digits = readDigitsIntoFixedArray(inputNumber);

        // Compute largest and second largest values.
        int[] topTwo = findLargestAndSecondLargest(digits);

        // Print result.
        System.out.println("Largest digit: " + topTwo[0]);
        System.out.println("Second largest digit: " + topTwo[1]);

        // Close scanner resource.
        scanner.close();
    }
}
