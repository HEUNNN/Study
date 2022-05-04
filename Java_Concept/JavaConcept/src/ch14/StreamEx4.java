package ch14;
import java.util.*;
import java.util.stream.*;

public class StreamEx4 {
    public static void main(String[] args) {
         Stream<String[]> strArrStream = Stream.of(
                 new String[] {"abc", "def", "jkl"},
                 new String[] {"ABC", "GHI", "JKL"}
         );

         // Stream<String[]> -> Stream<String>으로 변환
         // Stream<Stream<String>> strStreamStream = strArrStream.map(s -> Arrays.stream(s));
        Stream<String> strStream = strArrStream.flatMap(s -> Arrays.stream(s)); // Arrays::stream
        strStream.map(String::toLowerCase)
                .distinct() // 중복 제거
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };
        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))
                .map(String::toLowerCase)
                .forEach(System.out::println);
        System.out.println();

        Stream<String> strStream1 = Stream.of("AAA", "ABC", "bBb", "Dd");
        Stream<String> strStream2 = Stream.of("bbb", "aaa", "ccc", "dd");

        Stream<Stream<String>> strStreamStream = Stream.of(strStream1, strStream2);
        Stream<String> strStream3 = strStreamStream.map(s -> s.toArray(String[] ::new)).flatMap(Arrays::stream);
        strStream3.map(s -> s.toLowerCase())
                .distinct()
                .forEach(System.out::println);
    }
}
