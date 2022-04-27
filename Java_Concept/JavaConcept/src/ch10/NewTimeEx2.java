package ch10;

import java.time.*;

public class NewTimeEx2 {
    public static void main(String[] args) {
        LocalDate data = LocalDate.of(2022, 4, 30);
        LocalTime time = LocalTime.of(12, 34, 56);

        LocalDateTime dt = LocalDateTime.of(data, time);

        ZoneId zid = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdt = dt.atZone(zid);
        System.out.println(dt);
        System.out.println(zdt);

        ZonedDateTime seoultTime = ZonedDateTime.now();
        ZoneId nyId = ZoneId.of("America/New_York");
        LocalDateTime dt2 = LocalDateTime.now();
        ZonedDateTime nyTime = ZonedDateTime.of(dt2, nyId).withZoneSameInstant(nyId); // 아래 코드와 같은 결과
        ZonedDateTime nyTime2 = dt2.atZone(nyId);
        System.out.println(seoultTime);
        System.out.println(nyTime);
        System.out.println(nyTime2);

        // Offset Date Time
        OffsetDateTime odt = zdt.toOffsetDateTime();
        System.out.println(odt);
    }
}
