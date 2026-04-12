import java.util.Scanner;

public class W6_L1_TwoDArraySum {
    // Method to create and fill matrix.
    public static int[][] createMatrix(Scanner scanner, int rows, int columns) {
        // Declare 2D matrix.
        int[][] matrix = new int[rows][columns];

        // Read all matrix elements.
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                while (true) {
                    System.out.print("Enter value for [" + row + "][" + column + "]: ");
                    if (scanner.hasNextInt()) {
                        matrix[row][column] = scanner.nextInt();
                        break;
                    }
                    System.err.println("Invalid value. Enter an integer.");
                    scanner.next();
                }
            }
        }

        return matrix;
    }

    // Method to sum all values in matrix.
    public static int findMatrixSum(int[][] matrix) {
        // Initialize sum.
        int total = 0;

        // Traverse entire matrix.
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                total += matrix[row][column];
            }
        }

        return total;
    }

    // Method to print matrix values.
    public static void printMatrix(int[][] matrix) {
        // Print each row and column.
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create scanner for input.
        Scanner scanner = new Scanner(System.in);

        // Read row count.
        System.out.print("Enter row count: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Row count must be integer.");
            scanner.close();
            return;
        }
        int rowCount = scanner.nextInt();

        // Read column count.
        System.out.print("Enter column count: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Column count must be integer.");
            scanner.close();
            return;
        }
        int columnCount = scanner.nextInt();

        // Validate dimensions.
        if (rowCount <= 0 || columnCount <= 0) {
            System.err.println("Row and column count must be positive.");
            scanner.close();
            return;
        }

        // Build matrix from input.
        int[][] matrix = createMatrix(scanner, rowCount, columnCount);

        // Compute matrix sum.
        int matrixSum = findMatrixSum(matrix);

        // Display matrix and sum.
        System.out.println("\nMatrix values:");
        printMatrix(matrix);
        System.out.println("Sum of matrix elements: " + matrixSum);

        // Close scanner resource.
        scanner.close();
    }
}
