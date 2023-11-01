import java.sql.SQLOutput;
import java.util.Scanner;

public class LinearEquationLogic {

    Scanner scan = new Scanner(System.in);
    int x1;
    int x2;
    int y1;
    int y2;
    String point1;
    String point2;
    double x;

    public LinearEquationLogic() { }

    public void start() {
        System.out.println("Welcome to the  linear equation calculator!");
        String restart = "y";
        while (restart.equals("y")) {
            collectPoints();
            parsePoints(point1, point2);
            LinearEquation function = new LinearEquation(x1, y1, x2, y2);
            pointsInfo(function);
            if (x2 - x1 == 0) {
                collectX();
                printX(x, function);
            }
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            restart = scan.nextLine();
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }

    private void collectPoints() {
        System.out.print("Enter coordinate 1: ");
        point1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        point2 = scan.nextLine();
    }

    private void parsePoints(String point1, String point2) {
        x1 = Integer.parseInt(point1.substring(point1.indexOf("(") + 1, point1.indexOf(",")));
        y1 = Integer.parseInt(point1.substring(point1.indexOf(" ") + 1, point1.indexOf(")")));
        x2 = Integer.parseInt(point2.substring(point2.indexOf("(") + 1, point2.indexOf(",")));
        y2 = Integer.parseInt(point2.substring(point2.indexOf(" ") + 1, point2.indexOf(")")));
    }

    private void pointsInfo(LinearEquation function) {
        System.out.println(function.lineInfo());
    }

    private void collectX() {
        System.out.print("Enter a value for x: ");
        x = scan.nextDouble();
    }

    private void printX(double x, LinearEquation function) {
        System.out.println(function.coordinateForX(x));
    }
}
