import java.util.Arrays;

public class L3_RandomArrayStatistics {
    private static final int MIN_FOUR_DIGIT = 1000;
    private static final int FOUR_DIGIT_RANGE = 9000;

    public int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];

        for (int index = 0; index < size; index++) {
            randomNumbers[index] = (int) (Math.random() * FOUR_DIGIT_RANGE) + MIN_FOUR_DIGIT;
        }

        return randomNumbers;
    }

    public double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int minimumValue = numbers[0];
        int maximumValue = numbers[0];

        for (int number : numbers) {
            sum += number;
            minimumValue = Math.min(minimumValue, number);
            maximumValue = Math.max(maximumValue, number);
        }

        double averageValue = (double) sum / numbers.length;
        return new double[]{averageValue, minimumValue, maximumValue};
    }

    public static void main(String[] args) {
        L3_RandomArrayStatistics statisticsProgram = new L3_RandomArrayStatistics();
        int sampleSize = 5;

        int[] randomValues = statisticsProgram.generate4DigitRandomArray(sampleSize);
        double[] stats = statisticsProgram.findAverageMinMax(randomValues);

        System.out.println("Random Values: " + Arrays.toString(randomValues));
        System.out.println("Average: " + stats[0]);
        System.out.println("Minimum: " + (int) stats[1]);
        System.out.println("Maximum: " + (int) stats[2]);
    }
}
