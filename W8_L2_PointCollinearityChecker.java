import java.util.Scanner;

public class W8_L2_PointCollinearityChecker {
    public static boolean arePointsCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        double leftSide = (y2 - y1) * (x3 - x2);
        double rightSide = (y3 - y2) * (x2 - x1);
        return leftSide == rightSide;
    }

    public static boolean arePointsCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double areaExpression = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        double area = 0.5 * areaExpression;
        return area == 0.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.print("Enter x2 y2: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.print("Enter x3 y3: ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        boolean slopeMethodResult = arePointsCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areaMethodResult = arePointsCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Collinear by slope method: " + slopeMethodResult);
        System.out.println("Collinear by area method: " + areaMethodResult);

        scanner.close();
    }
}
