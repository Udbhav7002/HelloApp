import java.util.Scanner;

public class W5_L1_MatrixSumDisplay {
    // Method to create and fill a matrix from user input.
    public static int[][] readMatrix(Scanner scanner, int rowCount, int columnCount) {
        // Declare matrix using user-provided dimensions.
        int[][] matrix = new int[rowCount][columnCount];

        // Read each matrix element with validation.
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                while (true) {
                    System.out.print("Enter value for [" + row + "][" + column + "]: ");
                    if (scanner.hasNextInt()) {
                        matrix[row][column] = scanner.nextInt();
                        break;
                    }
                    System.err.println("Invalid input. Please enter an integer.");
                    scanner.next();
                }
            }
        }

        return matrix;
    }

    // Method to compute sum of all matrix elements.
    public static int calculateMatrixSum(int[][] matrix) {
        // Initialize matrix sum accumulator.
        int sum = 0;

        // Traverse all matrix cells using length property.
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                sum += matrix[row][column];
            }
        }

        return sum;
    }

    // Method to display matrix in grid format.
    public static void printMatrix(int[][] matrix) {
        // Print each row of matrix.
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create scanner object for console input.
        Scanner scanner = new Scanner(System.in);

        // Read and validate number of rows.
        System.out.print("Enter number of rows: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Rows must be an integer.");
            scanner.close();
            return;
        }
        int rows = scanner.nextInt();

        // Read and validate number of columns.
        System.out.print("Enter number of columns: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Columns must be an integer.");
            scanner.close();
            return;
        }
        int columns = scanner.nextInt();

        // Validate matrix dimensions.
        if (rows <= 0 || columns <= 0) {
            System.err.println("Rows and columns must be positive integers.");
            scanner.close();
            return;
        }

        // Build matrix from user input.
        int[][] matrix = readMatrix(scanner, rows, columns);

        // Compute matrix sum.
        int totalSum = calculateMatrixSum(matrix);

        // Display matrix and sum.
        System.out.println("\nMatrix:");
        printMatrix(matrix);
        System.out.println("Sum of all elements: " + totalSum);

        // Close scanner resource.
        scanner.close();
    }
}
