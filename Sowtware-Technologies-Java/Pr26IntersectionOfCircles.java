import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr26IntersectionOfCircles {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstCircleData = reader.readLine().split("\\s+");
        String[] secondCircleData = reader.readLine().split("\\s+");

        Circle firstCircle = new Circle();
        firstCircle.setRadius(Double.parseDouble(firstCircleData[2]));
        firstCircle.setX(Double.parseDouble(firstCircleData[0]));
        firstCircle.setY(Double.parseDouble(firstCircleData[1]));
        
        Circle secondCircle = new Circle();
        secondCircle.setRadius(Double.parseDouble(secondCircleData[2]));
        secondCircle.setX(Double.parseDouble(secondCircleData[0]));
        secondCircle.setY(Double.parseDouble(secondCircleData[1]));

        boolean circlesIntersect = Intersect(firstCircle, secondCircle);

        if (circlesIntersect) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean Intersect(Circle firstCircle, Circle secondCircle) {
        double x = Math.abs(firstCircle.getX() - secondCircle.getX());
        double y = Math.abs(firstCircle.getY() - secondCircle.getY());
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double sumRadius = firstCircle.getRadius() + secondCircle.getRadius();

        if (sumRadius >= distance) {
            return true;
        } else {
            return false;
        }
    }
}

class Circle {
    private double X;
    private double Y;
    private double Radius;

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getRadius() {
        return Radius;
    }

    public void setRadius(double radius) {
        Radius = radius;
    }
}
