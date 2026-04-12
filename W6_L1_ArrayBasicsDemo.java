import java.util.Scanner;

public class W6_L1_ArrayBasicsDemo {
    // Method to create and fill an array.
    public static int[] readArray(Scanner scanner, int size) {
        // Declare array with user size.
        int[] numbers = new int[size];

        // Input all elements with validation.
        for (int index = 0; index < numbers.length; index++) {
            while (true) {
                System.out.print("Enter value at index " + index + ": ");
                if (scanner.hasNextInt()) {
                    numbers[index] = scanner.nextInt();
                    break;
                }
                System.err.println("Invalid value. Enter an integer.");
                scanner.next();
            }
        }

        return numbers;
    }

    // Method to modify an element by index.
    public static boolean modifyArrayElement(int[] numbers, int index, int newValue) {
        // Validate index bounds.
        if (index < 0 || index >= numbers.length) {
            return false;
        }

        // Update array value.
        numbers[index] = newValue;
        return true;
    }

    // Method to print all array values.
    public static void printArray(int[] numbers) {
        // Print values using length property.
        for (int index = 0; index < numbers.length; index++) {
            System.out.print(numbers[index]);
            if (index < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create scanner object.
        Scanner scanner = new Scanner(System.in);

        // Read array size.
        System.out.print("Enter array size: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Size must be integer.");
            scanner.close();
            return;
        }
        int size = scanner.nextInt();

        // Validate array size.
        if (size <= 0) {
            System.err.println("Array size must be positive.");
            scanner.close();
            return;
        }

        // Read array data.
        int[] numbers = readArray(scanner, size);

        // Show original array.
        System.out.print("Original array: ");
        printArray(numbers);

        // Read index to modify.
        System.out.print("Enter index to modify: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid index.");
            scanner.close();
            return;
        }
        int targetIndex = scanner.nextInt();

        // Read new value.
        System.out.print("Enter new integer value: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid value.");
            scanner.close();
            return;
        }
        int newValue = scanner.nextInt();

        // Attempt update and print result.
        boolean updated = modifyArrayElement(numbers, targetIndex, newValue);
        if (!updated) {
            System.err.println("Index out of bounds.");
            scanner.close();
            return;
        }

        // Show updated array.
        System.out.print("Updated array: ");
        printArray(numbers);

        // Close scanner resource.
        scanner.close();
    }
}
