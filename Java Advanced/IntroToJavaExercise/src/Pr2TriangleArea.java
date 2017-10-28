import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr2TriangleArea {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] pointACoordinates = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] pointBCoordinates = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] pointDCoordinates = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int Ax = pointACoordinates[0];
        int Ay = pointACoordinates[1];
        int Bx = pointBCoordinates[0];
        int By = pointBCoordinates[1];
        int Dx = pointDCoordinates[0];
        int Dy = pointDCoordinates[1];

        double area = Math.abs((Ax * (By - Dy) + Bx * (Dy - Ay) + Dx * (Ay - By)) / 2);

        int areaNumber = (int)Math.round(area);

        System.out.println(areaNumber);

    }
}
