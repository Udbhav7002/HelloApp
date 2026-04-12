import java.util.Scanner;

public class W6_L2_LargestSecondLargestDynamic {
    private static final int INITIAL_CAPACITY = 10;
    private static final int CAPACITY_INCREMENT = 10;

    // Method to extract digits with dynamic array resizing.
    public static int[] extractDigitsDynamically(long number) {
        // Initialize capacity and digit storage.
        int capacity = INITIAL_CAPACITY;
        int[] digits = new int[capacity];
        int count = 0;
        long workingNumber = number;

        // Extract digits until number becomes zero.
        while (workingNumber != 0) {
            // Expand array when current capacity is full.
            if (count == capacity) {
                capacity += CAPACITY_INCREMENT;
                int[] temp = new int[capacity];
                for (int index = 0; index < digits.length; index++) {
                    temp[index] = digits[index];
                }
                digits = temp;
            }

            // Store next extracted digit.
            digits[count] = (int) (workingNumber % 10);
            workingNumber /= 10;
            count++;
        }

        // Copy only used digits into right-sized result array.
        int[] result = new int[count];
        for (int index = 0; index < result.length; index++) {
            result[index] = digits[index];
        }

        return result;
    }

    // Method to compute largest and second largest digits.
    public static int[] findLargestAndSecondLargest(int[] digits) {
        // Initialize largest trackers.
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Traverse all digits.
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
        // Create scanner for console input.
        Scanner scanner = new Scanner(System.in);

        // Read numeric input.
        System.out.print("Enter a non-negative number: ");
        if (!scanner.hasNextLong()) {
            System.err.println("Invalid input. Enter integer value.");
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

        // Handle zero input separately.
        if (inputNumber == 0) {
            System.out.println("Largest digit: 0");
            System.out.println("Second largest digit: 0");
            scanner.close();
            return;
        }

        // Extract digits with dynamic array growth.
        int[] digits = extractDigitsDynamically(inputNumber);

        // Find largest and second largest values.
        int[] result = findLargestAndSecondLargest(digits);

        // Display output values.
        System.out.println("Largest digit: " + result[0]);
        System.out.println("Second largest digit: " + result[1]);

        // Close scanner resource.
        scanner.close();
    }
}
