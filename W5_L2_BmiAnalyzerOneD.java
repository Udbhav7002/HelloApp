import java.util.Scanner;

public class W5_L2_BmiAnalyzerOneD {
    // Method to compute BMI given weight in kg and height in cm.
    public static double calculateBmi(double weightKg, double heightCm) {
        // Convert centimeters to meters.
        double heightMeters = heightCm / 100.0;

        // Compute BMI formula.
        return weightKg / (heightMeters * heightMeters);
    }

    // Method to map BMI value to status label.
    public static String findBmiStatus(double bmi) {
        // Determine status by standard thresholds.
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        // Create scanner object.
        Scanner scanner = new Scanner(System.in);

        // Read number of persons with validation.
        System.out.print("Enter number of persons: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Enter an integer value.");
            scanner.close();
            return;
        }
        int personCount = scanner.nextInt();

        // Validate person count.
        if (personCount <= 0) {
            System.err.println("Person count must be positive.");
            scanner.close();
            return;
        }

        // Create arrays for input and result values.
        double[] weightsKg = new double[personCount];
        double[] heightsCm = new double[personCount];
        double[] bmis = new double[personCount];
        String[] statuses = new String[personCount];

        // Read validated weight and height for each person.
        for (int index = 0; index < personCount; index++) {
            while (true) {
                System.out.print("Enter weight (kg) for person " + (index + 1) + ": ");
                if (!scanner.hasNextDouble()) {
                    System.err.println("Invalid weight. Enter numeric value.");
                    scanner.next();
                    continue;
                }
                double weight = scanner.nextDouble();

                System.out.print("Enter height (cm) for person " + (index + 1) + ": ");
                if (!scanner.hasNextDouble()) {
                    System.err.println("Invalid height. Enter numeric value.");
                    scanner.next();
                    continue;
                }
                double height = scanner.nextDouble();

                if (weight <= 0 || height <= 0) {
                    System.err.println("Weight and height must be positive. Re-enter this person.");
                    continue;
                }

                weightsKg[index] = weight;
                heightsCm[index] = height;
                break;
            }
        }

        // Compute BMI and status for all persons.
        for (int index = 0; index < personCount; index++) {
            bmis[index] = calculateBmi(weightsKg[index], heightsCm[index]);
            statuses[index] = findBmiStatus(bmis[index]);
        }

        // Display final report.
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\tStatus");
        for (int index = 0; index < personCount; index++) {
            System.out.println((index + 1) + "\t" + heightsCm[index] + "\t\t" + weightsKg[index] + "\t\t"
                    + String.format("%.2f", bmis[index]) + "\t" + statuses[index]);
        }

        // Close scanner resource.
        scanner.close();
    }
}
