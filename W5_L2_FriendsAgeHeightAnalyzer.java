import java.util.Scanner;

public class W5_L2_FriendsAgeHeightAnalyzer {
    private static final String[] FRIEND_NAMES = {"Amar", "Akbar", "Anthony"};

    // Method to read validated ages for three friends.
    public static int[] readAges(Scanner scanner) {
        // Declare age array.
        int[] ages = new int[FRIEND_NAMES.length];

        // Read each age with validation.
        for (int index = 0; index < ages.length; index++) {
            while (true) {
                System.out.print("Enter age of " + FRIEND_NAMES[index] + ": ");
                if (!scanner.hasNextInt()) {
                    System.err.println("Invalid age. Enter an integer.");
                    scanner.next();
                    continue;
                }
                int age = scanner.nextInt();
                if (age <= 0) {
                    System.err.println("Age must be positive.");
                    continue;
                }
                ages[index] = age;
                break;
            }
        }

        return ages;
    }

    // Method to read validated heights for three friends.
    public static double[] readHeights(Scanner scanner) {
        // Declare height array.
        double[] heights = new double[FRIEND_NAMES.length];

        // Read each height with validation.
        for (int index = 0; index < heights.length; index++) {
            while (true) {
                System.out.print("Enter height in cm of " + FRIEND_NAMES[index] + ": ");
                if (!scanner.hasNextDouble()) {
                    System.err.println("Invalid height. Enter a numeric value.");
                    scanner.next();
                    continue;
                }
                double height = scanner.nextDouble();
                if (height <= 0) {
                    System.err.println("Height must be positive.");
                    continue;
                }
                heights[index] = height;
                break;
            }
        }

        return heights;
    }

    // Method to find index of youngest friend.
    public static int findYoungestIndex(int[] ages) {
        // Assume first friend is youngest initially.
        int youngestIndex = 0;

        // Compare all ages.
        for (int index = 1; index < ages.length; index++) {
            if (ages[index] < ages[youngestIndex]) {
                youngestIndex = index;
            }
        }

        return youngestIndex;
    }

    // Method to find index of tallest friend.
    public static int findTallestIndex(double[] heights) {
        // Assume first friend is tallest initially.
        int tallestIndex = 0;

        // Compare all heights.
        for (int index = 1; index < heights.length; index++) {
            if (heights[index] > heights[tallestIndex]) {
                tallestIndex = index;
            }
        }

        return tallestIndex;
    }

    public static void main(String[] args) {
        // Create scanner object.
        Scanner scanner = new Scanner(System.in);

        // Read age and height arrays.
        int[] ages = readAges(scanner);
        double[] heights = readHeights(scanner);

        // Find result indices.
        int youngestIndex = findYoungestIndex(ages);
        int tallestIndex = findTallestIndex(heights);

        // Display final results.
        System.out.println("Youngest friend: " + FRIEND_NAMES[youngestIndex] + " (" + ages[youngestIndex] + " years)");
        System.out.println("Tallest friend: " + FRIEND_NAMES[tallestIndex] + " (" + heights[tallestIndex] + " cm)");

        // Close scanner resource.
        scanner.close();
    }
}
