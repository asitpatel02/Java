import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Get_Time_Date {
    public static void main(String[] args) {
        LocalDateTime current = LocalDateTime.now();

        DateTimeFormatter formaatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formated = current.format(formaatter);

        System.out.println("Current Date and Time is: "+formated);

        DateTimeFormatter formaatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String formated2 = current.format(formaatter2);

        System.out.println("Current Date and Time is: "+formated2);
    }
}
