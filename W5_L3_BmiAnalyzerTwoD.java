import java.util.Scanner;

public class W5_L3_BmiAnalyzerTwoD {
    private static final int WEIGHT_COLUMN = 0;
    private static final int HEIGHT_COLUMN = 1;
    private static final int BMI_COLUMN = 2;

    // Method to compute BMI value from weight and height.
    public static double calculateBmi(double weightKg, double heightCm) {
        // Convert height to meters and apply BMI formula.
        double heightMeters = heightCm / 100.0;
        return weightKg / (heightMeters * heightMeters);
    }

    // Method to return BMI status label for a BMI value.
    public static String findBmiStatus(double bmiValue) {
        // Apply threshold-based classification.
        if (bmiValue < 18.5) {
            return "Underweight";
        } else if (bmiValue < 25.0) {
            return "Normal";
        } else if (bmiValue < 30.0) {
            return "Overweight";
        }
        return "Obese";
    }

    public static void main(String[] args) {
        // Create scanner for user input.
        Scanner scanner = new Scanner(System.in);

        // Take and validate number of persons.
        System.out.print("Enter number of persons: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Enter an integer.");
            scanner.close();
            return;
        }
        int personCount = scanner.nextInt();

        // Validate person count.
        if (personCount <= 0) {
            System.err.println("Number of persons must be positive.");
            scanner.close();
            return;
        }

        // Create 2D array for weight, height, BMI and 1D array for status.
        double[][] personData = new double[personCount][3];
        String[] weightStatus = new String[personCount];

        // Read validated weight and height values.
        for (int index = 0; index < personData.length; index++) {
            while (true) {
                System.out.print("Enter weight (kg) for person " + (index + 1) + ": ");
                if (!scanner.hasNextDouble()) {
                    System.err.println("Invalid weight. Enter a numeric value.");
                    scanner.next();
                    continue;
                }
                double weight = scanner.nextDouble();

                System.out.print("Enter height (cm) for person " + (index + 1) + ": ");
                if (!scanner.hasNextDouble()) {
                    System.err.println("Invalid height. Enter a numeric value.");
                    scanner.next();
                    continue;
                }
                double height = scanner.nextDouble();

                if (weight <= 0 || height <= 0) {
                    System.err.println("Weight and height must be positive. Re-enter this person.");
                    continue;
                }

                personData[index][WEIGHT_COLUMN] = weight;
                personData[index][HEIGHT_COLUMN] = height;
                break;
            }
        }

        // Compute BMI and status for all persons.
        for (int index = 0; index < personData.length; index++) {
            double bmi = calculateBmi(personData[index][WEIGHT_COLUMN], personData[index][HEIGHT_COLUMN]);
            personData[index][BMI_COLUMN] = bmi;
            weightStatus[index] = findBmiStatus(bmi);
        }

        // Display final output table.
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\tStatus");
        for (int index = 0; index < personData.length; index++) {
            System.out.println((index + 1) + "\t" + personData[index][HEIGHT_COLUMN] + "\t\t"
                    + personData[index][WEIGHT_COLUMN] + "\t\t"
                    + String.format("%.2f", personData[index][BMI_COLUMN]) + "\t"
                    + weightStatus[index]);
        }

        // Close scanner resource.
        scanner.close();
    }
}
