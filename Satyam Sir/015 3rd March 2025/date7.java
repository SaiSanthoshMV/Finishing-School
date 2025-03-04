import java.time.*;
import java.time.format.*;

class date7 {
  public static void main(String[] args) {
    LocalDate date1 = LocalDate.now();
    LocalTime time1 = LocalTime.now();
    LocalDateTime dateTime1 = LocalDateTime.now();

    // LONG, MEDIUM, FULL, SHORT
    DateTimeFormatter shortDateTime =
      DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

    System.out.println(shortDateTime.format(dateTime1)); 
    System.out.println(shortDateTime.format(date1)); 
//    System.out.println(shortDateTime.format(time1));

    System.out.println(dateTime1.format(shortDateTime));
    System.out.println(date1.format(shortDateTime));
 //   System.out.println(time1.format(shortDateTime));
  } 
}

//LONG- March 3, 2025
// MEDIUM - Mar 3, 2025
// FULL - Monday, March 3, 2025
// SHORT - 3/3/25