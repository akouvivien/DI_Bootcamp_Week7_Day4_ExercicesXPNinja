import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //1:Which day of the week is today?
        LocalDate now = LocalDate.now();
        System.out.println("The day of week for today is " + now.getDayOfWeek());

        //2: Which day of the week is a date
        // Write a method to ask the user for a date. The user types day, month and year.
        LocalDate dateInput = askDate();
        System.out.println("The day of week for " + dateInput + " is " + dateInput.getDayOfWeek());

        //3: Which day of the week was your birthday?
        LocalDate dayOfWeekBirthday = LocalDate.of(1995, 6, 20);
        System.out.println("Day of week for my birthday is " + dayOfWeekBirthday.getDayOfWeek());

        //4: Time passed between two dates
        // How old are you, exactly, today?
        Period period = Period.between(dayOfWeekBirthday, now);
        System.out.println("Today, I'm exactly " + period.getYears() + " years " + period.getMonths() + " month(s) and " + period.getDays() + " day(s)");

        //5: Random day of a year
        // When a year is given, pick a random day of that year.
        System.out.println("Entrez l'année svp");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        LocalDate randomDate = randomDay(year);
        if (randomDate != null) {
            System.out.println("The random date is " + randomDate + " and that correspond to " + randomDate.getDayOfWeek());
        }

    }

    public static LocalDate askDate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the day of the date");
        int day = scanner.nextInt();

        System.out.println("Enter the month of the date");
        int month = scanner.nextInt();

        System.out.println("Enter the year of the date");
        int year = scanner.nextInt();

        return LocalDate.of(year, month, day);
    }

    public static LocalDate randomDay(int year) {
        Random random = new Random();

        int randomDay = random.nextInt(32)+1;
        int randomMonth = random.nextInt(13)+1;
        LocalDate localDate = null;
        try {
            localDate = LocalDate.of(year, randomMonth, randomDay);
        } catch (DateTimeException ex) {
            System.out.println(" date error !");
            ex.printStackTrace();
        }

        return localDate;

    }
}
