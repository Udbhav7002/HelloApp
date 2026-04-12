import java.util.Scanner;

public class W6_L1_ArrayLengthExplorer {
    // Method to fill an array from user input.
    public static int[] readValues(Scanner scanner, int arraySize) {
        // Allocate array with requested size.
        int[] values = new int[arraySize];

        // Read each element using length property.
        for (int index = 0; index < values.length; index++) {
            while (true) {
                System.out.print("Enter value " + (index + 1) + ": ");
                if (scanner.hasNextInt()) {
                    values[index] = scanner.nextInt();
                    break;
                }
                System.err.println("Invalid value. Please enter an integer.");
                scanner.next();
            }
        }

        return values;
    }

    // Method to compute min, max, and sum in one pass.
    public static int[] computeMinMaxSum(int[] values) {
        // Initialize min, max, and sum.
        int min = values[0];
        int max = values[0];
        int sum = 0;

        // Traverse values once using length property.
        for (int index = 0; index < values.length; index++) {
            int current = values[index];
            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
            sum += current;
        }

        return new int[]{min, max, sum};
    }

    public static void main(String[] args) {
        // Create scanner for input.
        Scanner scanner = new Scanner(System.in);

        // Read size from user.
        System.out.print("Enter number of elements: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid size. Enter integer value.");
            scanner.close();
            return;
        }
        int size = scanner.nextInt();

        // Validate size constraint.
        if (size <= 0) {
            System.err.println("Size must be greater than zero.");
            scanner.close();
            return;
        }

        // Read array values.
        int[] values = readValues(scanner, size);

        // Compute summary values.
        int[] summary = computeMinMaxSum(values);

        // Display result details.
        System.out.println("Array length: " + values.length);
        System.out.println("Minimum value: " + summary[0]);
        System.out.println("Maximum value: " + summary[1]);
        System.out.println("Sum of values: " + summary[2]);

        // Close scanner resource.
        scanner.close();
    }
}
