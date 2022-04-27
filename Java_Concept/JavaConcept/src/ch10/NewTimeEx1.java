package ch10;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewTimeEx1 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); // 오늘의 날짜
        LocalTime now = LocalTime.now(); // 현재 시간

        LocalDate birthDate = LocalDate.of(1998, 4, 30);
        LocalTime birthTime = LocalTime.of(23,59,59);

        System.out.println("today: " + today);
        System.out.println("now: " + now);
        System.out.println("birthDate: " + birthDate);
        System.out.println("birthTime: " + birthTime);

        LocalDate changedBirthDate = birthDate.withYear(2000);
        System.out.println("cahngedBirthDate: " + changedBirthDate); // birthDate 값 변경
        System.out.println("Plus Days: " + changedBirthDate.plusDays(1));

        // 23 : 59 : 59 -> 23 : 0 : 0
        System.out.println(birthTime.truncatedTo(ChronoUnit.HOURS)); // 지정된 것보다 작은 단위의 필드를 0으로 변경함

        System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range());
        System.out.println(ChronoField.HOUR_OF_DAY.range());
    }
}
