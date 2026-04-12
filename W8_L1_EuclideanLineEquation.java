import java.util.Scanner;

public class W8_L1_EuclideanLineEquation {
    public static double findEuclideanDistance(double x1, double y1, double x2, double y2) {
        double xDifference = x2 - x1;
        double yDifference = y2 - y1;
        return Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));
    }

    public static double[] findLineSlopeAndIntercept(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double intercept = y1 - (slope * x1);
        return new double[]{slope, intercept};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        if (x1 == x2) {
            System.out.println("Line is vertical. Equation: x = " + x1);
            System.out.println("Distance: " + findEuclideanDistance(x1, y1, x2, y2));
            scanner.close();
            return;
        }

        double distance = findEuclideanDistance(x1, y1, x2, y2);
        double[] lineDetails = findLineSlopeAndIntercept(x1, y1, x2, y2);
        double slope = lineDetails[0];
        double intercept = lineDetails[1];

        System.out.println("Distance: " + distance);
        System.out.println("Line Equation: y = " + slope + "x + " + intercept);

        scanner.close();
    }
}
