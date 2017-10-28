import java.util.Scanner;

public class Pr12ToTheStars {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Star[] stars = readStars();
        makeMovement(stars);
    }

    private static void makeMovement(Star[] stars) {
        String[] line = scanner.nextLine().split("\\s+");
        Star normandy = new Star("Normandy", Double.parseDouble(line[0]), Double.parseDouble(line[1]));
        int moves = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= moves; i++) {
            String location = getNormandyLocation(normandy, stars);
            if (location != null) {
                System.out.println(location);
            } else {
                System.out.println("space");
            }
            normandy.y++;
        }
    }

    private static String getNormandyLocation(Star normandy, Star[] stars) {
        for (Star star : stars) {
            if (star.containsNormandy(normandy)) {
                return star.name;
            }
        }
        return null;
    }

    private static Star[] readStars() {
        Star[] stars = new Star[3];
        for (int i = 0; i < 3; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            Star star = new Star(line[0], Double.parseDouble(line[1]), Double.parseDouble(line[2]));
            stars[i] = star;
        }
        return stars;
    }

    static class Star {
        double x;
        double y;
        String name;

        Star(String name, double x, double y) {
            this.x = x;
            this.y = y;
            this.name = name.toLowerCase();
        }

        boolean containsNormandy(Star normandy) {
            double top = this.y + 1;
            double bottom = this.y - 1;
            double right = this.x + 1;
            double left = this.x - 1;
            return normandy.x <= right && normandy.x >= left && normandy.y >= bottom && normandy.y <= top;
        }
    }
}
