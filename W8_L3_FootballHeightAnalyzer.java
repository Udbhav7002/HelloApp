import java.util.Arrays;

public class W8_L3_FootballHeightAnalyzer {
    private static final int PLAYER_COUNT = 11;
    private static final int MIN_HEIGHT_CM = 150;
    private static final int HEIGHT_RANGE_CM = 101;

    public static int[] generateRandomHeightsArray(int size) {
        int[] heights = new int[size];

        for (int index = 0; index < size; index++) {
            heights[index] = (int) (Math.random() * HEIGHT_RANGE_CM) + MIN_HEIGHT_CM;
        }

        return heights;
    }

    public static int findSumOfHeights(int[] heights) {
        int totalHeight = 0;
        for (int height : heights) {
            totalHeight += height;
        }
        return totalHeight;
    }

    public static double findMeanHeight(int[] heights) {
        int totalHeight = findSumOfHeights(heights);
        return totalHeight / (double) heights.length;
    }

    public static int findShortestHeight(int[] heights) {
        int shortestHeight = heights[0];
        for (int height : heights) {
            shortestHeight = Math.min(shortestHeight, height);
        }
        return shortestHeight;
    }

    public static int findTallestHeight(int[] heights) {
        int tallestHeight = heights[0];
        for (int height : heights) {
            tallestHeight = Math.max(tallestHeight, height);
        }
        return tallestHeight;
    }

    public static void main(String[] args) {
        int[] heights = generateRandomHeightsArray(PLAYER_COUNT);
        int shortestHeight = findShortestHeight(heights);
        int tallestHeight = findTallestHeight(heights);
        double meanHeight = findMeanHeight(heights);

        System.out.println("Player heights (cm): " + Arrays.toString(heights));
        System.out.println("Shortest height: " + shortestHeight + " cm");
        System.out.println("Tallest height: " + tallestHeight + " cm");
        System.out.println("Mean height: " + meanHeight + " cm");
    }
}
