import java.text.DecimalFormat;

public class LinearEquation {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double yIntercept() {
        return roundedToHundredth(y1 - slope() * x1);
    }

    public double slope() {
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public String equation() {
        int run = x2 - x1;
        int rise = y2 - y1;
        String slopeSign = "";
        String slopeDisplay = "" + rise / run;
        String interceptSign = "+";
        String interceptDisplay = "";

        if (run < 0 || rise < 0) {
            slopeSign = "-";
            if ((run < 0 && rise < 0) || slope() == 0) {
                slopeSign = "";
            }
            run = Math.abs(run);
            rise = Math.abs(rise);
        }

        if (run != 0) {
            if (yIntercept() < 0) {
                interceptSign = "-";  //problem --7x? SLOPE DISPLAY
                interceptDisplay += Math.abs(yIntercept());
            } else if (yIntercept() == 0) {
                interceptSign = "";
            } else {
                interceptDisplay += Math.abs(yIntercept());
            }
        }

        if (slopeDisplay.equals("1")) {  //add a -1
            slopeDisplay = "";
        }

        if (run == 0) {
            return "x = " + x1;
        } else if (rise % run == 0) {
            return "y = " + slopeSign + slopeDisplay + "x " + interceptSign + " " + interceptDisplay;
        } else if (rise != 0) {
            return "y = " + slopeSign + rise + "/" + run + "x " + interceptSign + " " + interceptDisplay;
        } else {
          return "y = " + yIntercept(); //engineer swap
        }
    }

    public String coordinateForX(double x) {
        return "The point on the line is (" + x + ", " + (slope() * x + yIntercept()) + ")";
    }

    public String lineInfo() {
        String pointsInfo = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        String equationInfo = "The equation of the line between these points is: " + equation();
        String slopeOutput = "";
        if (!equationInfo.substring(0, 1).equals("x")) {
            slopeOutput += slope();
        } else {
            slopeOutput += "undefined";
        }
        String slopeInfo = "The slope of this line is: " + slopeOutput;
        String interceptOutput = "";
        if (!equationInfo.substring(0, 1).equals("x")) {
            interceptOutput += ": " + yIntercept();
        } else if (equationInfo.substring(0, 1).equals("x = 0")) {
            interceptOutput += " found on infinitely many points";
        } else {
            interceptOutput += " not found on any point";
        }
        String yInterceptInfo = "The y-intercept of this line is" + interceptOutput;
        String distanceInfo = "The distance between these points is: " + distance();
        return "\n" + pointsInfo + "\n" + equationInfo + "\n" + slopeInfo + "\n" + yInterceptInfo + "\n" + distanceInfo + "\n";
    }

    private double roundedToHundredth(double toRound) {
        return Math.floor(toRound * 100) / 100;
    }
}
