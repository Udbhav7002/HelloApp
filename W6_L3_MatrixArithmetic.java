import java.util.Scanner;

public class W6_L3_MatrixArithmetic {
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_RANGE = 9;

    // Method to create a random matrix.
    public static int[][] createRandomMatrix(int rows, int columns) {
        // Allocate matrix by dimensions.
        int[][] matrix = new int[rows][columns];

        // Fill matrix with random values.
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = (int) (Math.random() * RANDOM_RANGE) + RANDOM_MIN;
            }
        }

        return matrix;
    }

    // Method to add two matrices.
    public static int[][] addMatrices(int[][] first, int[][] second) {
        // Allocate result matrix.
        int[][] result = new int[first.length][first[0].length];

        // Perform element-wise addition.
        for (int row = 0; row < first.length; row++) {
            for (int column = 0; column < first[row].length; column++) {
                result[row][column] = first[row][column] + second[row][column];
            }
        }

        return result;
    }

    // Method to subtract second matrix from first matrix.
    public static int[][] subtractMatrices(int[][] first, int[][] second) {
        // Allocate result matrix.
        int[][] result = new int[first.length][first[0].length];

        // Perform element-wise subtraction.
        for (int row = 0; row < first.length; row++) {
            for (int column = 0; column < first[row].length; column++) {
                result[row][column] = first[row][column] - second[row][column];
            }
        }

        return result;
    }

    // Method to multiply two matrices.
    public static int[][] multiplyMatrices(int[][] first, int[][] second) {
        // Allocate result matrix for multiplication output.
        int[][] result = new int[first.length][second[0].length];

        // Triple loop multiplication logic.
        for (int row = 0; row < first.length; row++) {
            for (int column = 0; column < second[0].length; column++) {
                int value = 0;
                for (int index = 0; index < first[0].length; index++) {
                    value += first[row][index] * second[index][column];
                }
                result[row][column] = value;
            }
        }

        return result;
    }

    // Method to print a matrix.
    public static void printMatrix(String title, int[][] matrix) {
        // Print title and matrix values.
        System.out.println(title);
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create scanner object.
        Scanner scanner = new Scanner(System.in);

        // Read and validate row count.
        System.out.print("Enter row count: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid rows input.");
            scanner.close();
            return;
        }
        int rows = scanner.nextInt();

        // Read and validate column count.
        System.out.print("Enter column count: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid columns input.");
            scanner.close();
            return;
        }
        int columns = scanner.nextInt();

        // Validate matrix dimensions.
        if (rows <= 0 || columns <= 0) {
            System.err.println("Rows and columns must be positive.");
            scanner.close();
            return;
        }

        // Build two random matrices with same dimensions.
        int[][] matrixA = createRandomMatrix(rows, columns);
        int[][] matrixB = createRandomMatrix(rows, columns);

        // Compute addition and subtraction.
        int[][] matrixSum = addMatrices(matrixA, matrixB);
        int[][] matrixDifference = subtractMatrices(matrixA, matrixB);

        // Prepare multiplication only when dimensions are valid.
        int[][] matrixProduct = multiplyMatrices(matrixA, matrixB);

        // Print matrices and operations.
        printMatrix("Matrix A:", matrixA);
        printMatrix("Matrix B:", matrixB);
        printMatrix("A + B:", matrixSum);
        printMatrix("A - B:", matrixDifference);
        printMatrix("A x B:", matrixProduct);

        // Close scanner resource.
        scanner.close();
    }
}
