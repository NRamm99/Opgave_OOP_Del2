import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {
    private final LocalDateTime dateTime;
    private final String formattedDate;
    private final String dayOfWeek;

    public Date () {
        this.dateTime = LocalDateTime.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("EEEE");

        this.formattedDate = dateTime.format(dateFormatter);
        this.dayOfWeek = dateTime.format(dayFormatter);
    }

    public String getFormattedDate(){
        return formattedDate;
    }

    public String getDayOfWeek(){
        return dayOfWeek;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String toString() {
        return dayOfWeek + ", " + formattedDate;
    }
}
