package hello.typeconverter.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

public class MyNumberFormatterTest {
    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() throws ParseException { // 문자 → 숫자
        Number result = formatter.parse("1,000", Locale.KOREA);
        System.out.println(result);
        assertThat(result).isEqualTo(1000L); // Long type
    }

    @Test
    void print() {
        String result = formatter.print(1000, Locale.KOREA);
        System.out.println(result);
        assertThat(result).isEqualTo("1,000");
    }
}
