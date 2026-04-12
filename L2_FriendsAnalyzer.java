import java.util.Scanner;

public class L2_FriendsAnalyzer {
    private static final String[] FRIEND_NAMES = {"Amar", "Akbar", "Anthony"};

    public static int findYoungestFriendIndex(int[] ages) {
        int youngestIndex = 0;

        for (int index = 1; index < ages.length; index++) {
            if (ages[index] < ages[youngestIndex]) {
                youngestIndex = index;
            }
        }

        return youngestIndex;
    }

    public static int findTallestFriendIndex(double[] heights) {
        int tallestIndex = 0;

        for (int index = 1; index < heights.length; index++) {
            if (heights[index] > heights[tallestIndex]) {
                tallestIndex = index;
            }
        }

        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int[] ages = new int[FRIEND_NAMES.length];
        double[] heights = new double[FRIEND_NAMES.length];

        for (int index = 0; index < FRIEND_NAMES.length; index++) {
            System.out.print("Enter age of " + FRIEND_NAMES[index] + ": ");
            ages[index] = inputScanner.nextInt();
            System.out.print("Enter height (cm) of " + FRIEND_NAMES[index] + ": ");
            heights[index] = inputScanner.nextDouble();
        }

        int youngestIndex = findYoungestFriendIndex(ages);
        int tallestIndex = findTallestFriendIndex(heights);

        System.out.println("Youngest friend: " + FRIEND_NAMES[youngestIndex] + " (" + ages[youngestIndex] + " years)");
        System.out.println("Tallest friend: " + FRIEND_NAMES[tallestIndex] + " (" + heights[tallestIndex] + " cm)");

        inputScanner.close();
    }
}
