package ch14;

import java.util.*;
import java.util.stream.*;

public class StreamEx6 {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };
        Stream.of(strArr).forEach(System.out::println);
        System.out.println();

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
        System.out.println("noEmptyStr = " + noEmptyStr); // true
        Optional<String> sWord = Stream.of(strArr).filter(s -> s.charAt(0) == 's').findFirst();
        System.out.println("sWord = " + sWord.get()); // sWord = stream
        System.out.println();

        // Stream<String[]>을 IntStream으로 변환
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (curr, next) -> curr + 1);
        int sum = intStream2.reduce(0, (curr, next) -> curr + next);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        System.out.println("count: " + count);
        System.out.println("sum: " + sum);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}
