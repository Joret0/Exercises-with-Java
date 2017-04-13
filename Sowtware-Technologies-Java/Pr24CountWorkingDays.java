import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Pr24CountWorkingDays {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String first = reader.readLine();
        String second = reader.readLine();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate firstDate = LocalDate.parse(first, dateFormat);
        LocalDate secondDate = LocalDate.parse(second, dateFormat);

        long days = ChronoUnit.DAYS.between(firstDate, secondDate);

        int workingDays = 0;

        for (int i = 0; i <= days; i++) {
            boolean workDay = checkIfIsHoliday(firstDate);

            if (!workDay) {
                workingDays++;
            }
            firstDate = firstDate.plusDays(1);
        }
        System.out.println(workingDays);
    }

    private static boolean checkIfIsHoliday(LocalDate date) {
        if ((date.getDayOfMonth() == 1 && date.getMonth().getValue() == 1) ||
                (date.getDayOfMonth() == 3 && date.getMonth().getValue() == 3) ||
                (date.getDayOfMonth() == 1 && date.getMonth().getValue() == 5) ||
                (date.getDayOfMonth() == 6 && date.getMonth().getValue() == 5) ||
                (date.getDayOfMonth() == 24 && date.getMonth().getValue() == 5) ||
                (date.getDayOfMonth() == 6 && date.getMonth().getValue() == 9) ||
                (date.getDayOfMonth() == 22 && date.getMonth().getValue() == 9) ||
                (date.getDayOfMonth() == 1 && date.getMonth().getValue() == 11) ||
                (date.getDayOfMonth() == 24 && date.getMonth().getValue() == 12) ||
                (date.getDayOfMonth() == 25 && date.getMonth().getValue() == 12) ||
                (date.getDayOfMonth() == 26 && date.getMonth().getValue() == 12)) {
            return true;
        } else if ((date.getDayOfWeek().getValue() == 6) ||
                (date.getDayOfWeek().getValue() == 7)) {
            return true;
        } else {
            return false;
        }
    }
}
