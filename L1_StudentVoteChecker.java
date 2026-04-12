import java.util.Scanner;

public class L1_StudentVoteChecker {
    private static final int TOTAL_STUDENTS = 10;
    private static final int MINIMUM_VOTING_AGE = 18;

    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= MINIMUM_VOTING_AGE;
    }

    public static void main(String[] args) {
        L1_StudentVoteChecker voteChecker = new L1_StudentVoteChecker();
        Scanner inputScanner = new Scanner(System.in);
        int[] studentAges = new int[TOTAL_STUDENTS];

        for (int index = 0; index < TOTAL_STUDENTS; index++) {
            System.out.print("Enter age of student " + (index + 1) + ": ");
            studentAges[index] = inputScanner.nextInt();
        }

        System.out.println("\nVoting Eligibility Results:");
        for (int index = 0; index < TOTAL_STUDENTS; index++) {
            int currentAge = studentAges[index];
            boolean eligibility = voteChecker.canStudentVote(currentAge);
            System.out.println("Student " + (index + 1) + " (Age " + currentAge + ") -> "
                    + (eligibility ? "Can Vote" : "Cannot Vote"));
        }

        inputScanner.close();
    }
}
