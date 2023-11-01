import java.text.DecimalFormat;

public class LinearEquation {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double yIntercept() {
        return roundedToHundredth(y1 - slope() / x1);
    }

    public double slope() {
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public String equation() {
        if (y2 - y1 != 0) {
          return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x + " + yIntercept();
        } else {
          return "y = " + yIntercept();
        }
    }

    public String coordinateForX(double x) {
        return "The point on the line is (" + x + ", " + (slope() * x + yIntercept()) + ")";
    }

    public String lineInfo() {
        String pointsInfo = "The two points are: (" + x1 + ", " + x2 + ") and (" + y1 + ", " + y2 + ")";
        String equationInfo = "The equation of the line between these points is: " + equation();
        String slopeInfo = "The slope of this line is: " + slope();
        String yInterceptInfo = "The y-intercept of this line is " + yIntercept();
        String distanceInfo = "The distance between these points is " + distance();
        return "\n" + pointsInfo + "\n" + equationInfo + "\n" + slopeInfo + "\n" + yInterceptInfo + "\n" + distanceInfo + "\n";
    }

    private double roundedToHundredth(double toRound) {
        return Math.floor(toRound * 100) / 100;
    }
}
