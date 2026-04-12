import java.util.Scanner;

public class W5_L2_EmployeeBonusPayout {
    private static final int EMPLOYEE_COUNT = 10;
    private static final double HIGH_BONUS_RATE = 0.05;
    private static final double LOW_BONUS_RATE = 0.02;
    private static final int SERVICE_THRESHOLD = 5;

    // Method to read validated employee salary and years of service.
    public static double[][] readEmployeeData(Scanner scanner) {
        // Store salary and service years for each employee.
        double[][] employeeData = new double[EMPLOYEE_COUNT][2];

        // Read all employees with validation.
        for (int index = 0; index < employeeData.length; index++) {
            while (true) {
                System.out.print("Enter salary for employee " + (index + 1) + ": ");
                if (!scanner.hasNextDouble()) {
                    System.err.println("Invalid salary. Enter a numeric value.");
                    scanner.next();
                    continue;
                }
                double salary = scanner.nextDouble();

                System.out.print("Enter years of service for employee " + (index + 1) + ": ");
                if (!scanner.hasNextDouble()) {
                    System.err.println("Invalid years. Enter a numeric value.");
                    scanner.next();
                    continue;
                }
                double years = scanner.nextDouble();

                if (salary <= 0 || years < 0) {
                    System.err.println("Salary must be > 0 and years must be >= 0. Re-enter this employee.");
                    continue;
                }

                employeeData[index][0] = salary;
                employeeData[index][1] = years;
                break;
            }
        }

        return employeeData;
    }

    // Method to compute new salary and bonus for each employee.
    public static double[][] calculateBonusData(double[][] employeeData) {
        // Store new salary and bonus amount for each employee.
        double[][] bonusData = new double[employeeData.length][2];

        // Calculate bonus and new salary.
        for (int index = 0; index < employeeData.length; index++) {
            double currentSalary = employeeData[index][0];
            double yearsOfService = employeeData[index][1];

            double bonusRate = yearsOfService > SERVICE_THRESHOLD ? HIGH_BONUS_RATE : LOW_BONUS_RATE;
            double bonusAmount = currentSalary * bonusRate;
            double newSalary = currentSalary + bonusAmount;

            bonusData[index][0] = newSalary;
            bonusData[index][1] = bonusAmount;
        }

        return bonusData;
    }

    // Method to display total old salary, new salary, and bonus payout.
    public static void printBonusSummary(double[][] employeeData, double[][] bonusData) {
        // Initialize totals.
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        double totalBonus = 0.0;

        // Print per-employee detail and accumulate totals.
        System.out.println("Emp\tOldSalary\tYears\tBonus\tNewSalary");
        for (int index = 0; index < employeeData.length; index++) {
            double oldSalary = employeeData[index][0];
            double years = employeeData[index][1];
            double bonus = bonusData[index][1];
            double newSalary = bonusData[index][0];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.println((index + 1) + "\t" + oldSalary + "\t" + years + "\t" + bonus + "\t" + newSalary);
        }

        // Print totals.
        System.out.println("\nTotal old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
        System.out.println("Total bonus payout: " + totalBonus);
    }

    public static void main(String[] args) {
        // Create scanner for input.
        Scanner scanner = new Scanner(System.in);

        // Read validated employee inputs.
        double[][] employeeData = readEmployeeData(scanner);

        // Compute bonus and updated salary outputs.
        double[][] bonusData = calculateBonusData(employeeData);

        // Display summary table.
        printBonusSummary(employeeData, bonusData);

        // Close scanner resource.
        scanner.close();
    }
}
