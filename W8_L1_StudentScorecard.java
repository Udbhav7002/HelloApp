import java.util.Scanner;

public class W8_L1_StudentScorecard {
    private static final int SUBJECT_COUNT = 3;
    private static final int MIN_MARKS = 10;
    private static final int TWO_DIGIT_RANGE = 90;

    public static int[][] generateRandomPcmScores(int studentCount) {
        int[][] scores = new int[studentCount][SUBJECT_COUNT];

        for (int student = 0; student < studentCount; student++) {
            for (int subject = 0; subject < SUBJECT_COUNT; subject++) {
                scores[student][subject] = (int) (Math.random() * TWO_DIGIT_RANGE) + MIN_MARKS;
            }
        }

        return scores;
    }

    public static double[][] calculateTotalAveragePercentage(int[][] scores) {
        double[][] computedValues = new double[scores.length][3];

        for (int student = 0; student < scores.length; student++) {
            int total = scores[student][0] + scores[student][1] + scores[student][2];
            double average = total / (double) SUBJECT_COUNT;
            double percentage = (total / (double) (SUBJECT_COUNT * 100)) * 100;

            computedValues[student][0] = total;
            computedValues[student][1] = Math.round(average * 100.0) / 100.0;
            computedValues[student][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return computedValues;
    }

    public static void displayScorecard(int[][] scores, double[][] computedValues) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");

        for (int student = 0; student < scores.length; student++) {
            System.out.println((student + 1) + "\t" + scores[student][0] + "\t" + scores[student][1]
                    + "\t\t" + scores[student][2] + "\t" + (int) computedValues[student][0]
                    + "\t" + computedValues[student][1] + "\t" + computedValues[student][2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int studentCount = scanner.nextInt();

        if (studentCount <= 0) {
            System.out.println("Student count must be positive.");
            scanner.close();
            return;
        }

        int[][] pcmScores = generateRandomPcmScores(studentCount);
        double[][] computedValues = calculateTotalAveragePercentage(pcmScores);
        displayScorecard(pcmScores, computedValues);

        scanner.close();
    }
}
