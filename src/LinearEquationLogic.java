import java.util.Scanner;

public class LinearEquationLogic {

    Scanner scan = new Scanner(System.in);

    public LinearEquationLogic() { }

    public void start() {
    }

    public void printData() {
        System.out.print("Enter coordinate 1: ");
        String point1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String point2 = scan.nextLine();
        int x1 = Integer.parseInt(point1.substring(point1.indexOf("(") + 1, point1.indexOf(",")));
        int x2 = Integer.parseInt(point1.substring(point1.indexOf(" ") + 1, point1.indexOf(")")));
        int y1 = Integer.parseInt(point2.substring(point1.indexOf("(") + 1, point1.indexOf(",")));
        int y2 = Integer.parseInt(point2.substring(point1.indexOf(" ") + 1, point1.indexOf(")")));
        LinearEquation pointsInfo = new LinearEquation(x1, x2, y1, y2);
    }

    public void printX() {

    }

}
