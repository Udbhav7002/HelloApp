public class W8_L2_EmployeeBonusCalculator {
    private static final int EMPLOYEE_COUNT = 10;
    private static final int SALARY_MIN = 10000;
    private static final int SALARY_RANGE = 90000;
    private static final int SERVICE_YEARS_MAX = 11;
    private static final double HIGH_BONUS_PERCENT = 0.05;
    private static final double LOW_BONUS_PERCENT = 0.02;

    public static double[][] generateSalaryAndServiceData(int employeeCount) {
        double[][] employeeData = new double[employeeCount][2];

        for (int index = 0; index < employeeCount; index++) {
            double salary = (int) (Math.random() * SALARY_RANGE) + SALARY_MIN;
            int yearsOfService = (int) (Math.random() * SERVICE_YEARS_MAX);
            employeeData[index][0] = salary;
            employeeData[index][1] = yearsOfService;
        }

        return employeeData;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] updatedData = new double[employeeData.length][2];

        for (int index = 0; index < employeeData.length; index++) {
            double oldSalary = employeeData[index][0];
            double yearsOfService = employeeData[index][1];
            double bonusRate = yearsOfService > 5 ? HIGH_BONUS_PERCENT : LOW_BONUS_PERCENT;
            double bonusAmount = oldSalary * bonusRate;
            double newSalary = oldSalary + bonusAmount;

            updatedData[index][0] = newSalary;
            updatedData[index][1] = bonusAmount;
        }

        return updatedData;
    }

    public static void displayBonusReport(double[][] employeeData, double[][] updatedData) {
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        double totalBonus = 0.0;

        System.out.println("Emp\tOldSalary\tYears\tBonus\tNewSalary");
        for (int index = 0; index < employeeData.length; index++) {
            double oldSalary = employeeData[index][0];
            int yearsOfService = (int) employeeData[index][1];
            double bonusAmount = updatedData[index][1];
            double newSalary = updatedData[index][0];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonusAmount;

            System.out.println((index + 1) + "\t" + oldSalary + "\t" + yearsOfService + "\t" + bonusAmount + "\t" + newSalary);
        }

        System.out.println("\nTotals");
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        System.out.println("Total Bonus: " + totalBonus);
    }

    public static void main(String[] args) {
        double[][] employeeData = generateSalaryAndServiceData(EMPLOYEE_COUNT);
        double[][] updatedData = calculateNewSalaryAndBonus(employeeData);
        displayBonusReport(employeeData, updatedData);
    }
}
