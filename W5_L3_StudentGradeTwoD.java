import java.util.Scanner;

public class W5_L3_StudentGradeTwoD {
    private static final int SUBJECT_COUNT = 3;
    private static final int PHYSICS_COLUMN = 0;
    private static final int CHEMISTRY_COLUMN = 1;
    private static final int MATHS_COLUMN = 2;

    // Method to compute grade based on percentage.
    public static String findGrade(double percentage) {
        // Map percentage to grade bands.
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 40) {
            return "D";
        }
        return "F";
    }

    public static void main(String[] args) {
        // Create scanner object for input.
        Scanner scanner = new Scanner(System.in);

        // Read and validate number of students.
        System.out.print("Enter number of students: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Enter an integer.");
            scanner.close();
            return;
        }
        int studentCount = scanner.nextInt();

        // Validate student count.
        if (studentCount <= 0) {
            System.err.println("Student count must be positive.");
            scanner.close();
            return;
        }

        // Create arrays for marks, percentage and grade.
        int[][] marks = new int[studentCount][SUBJECT_COUNT];
        double[] percentages = new double[studentCount];
        String[] grades = new String[studentCount];

        // Take validated marks input for each subject.
        for (int student = 0; student < marks.length; student++) {
            while (true) {
                System.out.print("Enter Physics marks for student " + (student + 1) + ": ");
                if (!scanner.hasNextInt()) {
                    System.err.println("Invalid marks. Enter an integer.");
                    scanner.next();
                    continue;
                }
                int physics = scanner.nextInt();

                System.out.print("Enter Chemistry marks for student " + (student + 1) + ": ");
                if (!scanner.hasNextInt()) {
                    System.err.println("Invalid marks. Enter an integer.");
                    scanner.next();
                    continue;
                }
                int chemistry = scanner.nextInt();

                System.out.print("Enter Maths marks for student " + (student + 1) + ": ");
                if (!scanner.hasNextInt()) {
                    System.err.println("Invalid marks. Enter an integer.");
                    scanner.next();
                    continue;
                }
                int maths = scanner.nextInt();

                if (physics < 0 || chemistry < 0 || maths < 0 || physics > 100 || chemistry > 100 || maths > 100) {
                    System.err.println("Marks must be between 0 and 100. Re-enter this student.");
                    continue;
                }

                marks[student][PHYSICS_COLUMN] = physics;
                marks[student][CHEMISTRY_COLUMN] = chemistry;
                marks[student][MATHS_COLUMN] = maths;
                break;
            }
        }

        // Compute percentages and grades.
        for (int student = 0; student < marks.length; student++) {
            int total = marks[student][PHYSICS_COLUMN] + marks[student][CHEMISTRY_COLUMN] + marks[student][MATHS_COLUMN];
            double percentage = total / (double) SUBJECT_COUNT;
            percentages[student] = Math.round(percentage * 100.0) / 100.0;
            grades[student] = findGrade(percentages[student]);
        }

        // Display scorecard.
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int student = 0; student < marks.length; student++) {
            System.out.println((student + 1) + "\t" + marks[student][PHYSICS_COLUMN] + "\t" + marks[student][CHEMISTRY_COLUMN]
                    + "\t\t" + marks[student][MATHS_COLUMN] + "\t" + percentages[student] + "\t\t" + grades[student]);
        }

        // Close scanner object.
        scanner.close();
    }
}
