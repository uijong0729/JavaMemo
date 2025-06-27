package ocjp.gold.myLocale;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocaleSample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2021, 4, 1);
        // 2021년 4월 1일
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy'年' MMMM d'日' eeee");
        System.out.println(formatter.format(date));

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy'年' MMM d'日' eeee");
        System.out.println(formatter2.format(date));

        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy'年' MM d'日' eeee");
        System.out.println(formatter3.format(date));
    }
}
