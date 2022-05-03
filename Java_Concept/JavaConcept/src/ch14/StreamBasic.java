package ch14;

import java.util.*;
import java.util.stream.*;

public class StreamBasic {
    public static void main(String[] args) {
        // Collection의 자손인 List, Set을 구현한 컬렉션 클래스(ex. ArrayList)들은 스트림을 생성할 수 있다. -> Collection에 stream()이 정의되어 있기때문이다.

        System.out.println("List로부터 Stream 생성");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); // 가변 인자
        Stream<Integer> listStream = list.stream(); // list를 소스로 하는 컬렉션 생성
        listStream.forEach(System.out::println); // 스트림의 모든 요소를 출력
        // intStream.forEach(System.out::println); // 에러. 스트림이 이미 소모되어 닫힘
        System.out.println("List로부터 Stream 생성");
        Set<Integer> set = new HashSet();
        for (int i = 1; i < 6; i++) set.add(i);
        Stream<Integer> setStream = set.stream();
        setStream.forEach(System.out::println);

        // 배열을 소스로 하는 스트림 생성 -> Stream과 Arrays 클래스 둘 다에 static 메서드로 정의되어 있음
        System.out.println("Array로부터 Stream 생성");
        Stream<String> strStream1 = Stream.of("a", "b", "c"); // 가변 인자
        Stream<String> strStream2 = Stream.of(new String[] {"a", "b", "c"});
        Stream<String> strStream3 = Arrays.stream(new String[] {"a", "b", "c"});
        Stream<String> strStream4 = Arrays.stream(new String[] {"a", "b", "c"}, 1, 3); // b, c
        strStream1.forEach(System.out::println);
        // 기본형 배열을 소스로 하는 스트림 생성
        System.out.println("기본형 Array로부터 Stream 생성");
        IntStream intStream1 = IntStream.of(1, 2, 3);
        IntStream intStream2 = IntStream.of(new int[] {1, 2, 3});
        IntStream intStream3 = Arrays.stream(new int[] {1, 2, 3});
        IntStream intStream4 = Arrays.stream(new int[] {1, 2, 3}, 1, 3); // 2, 3
        intStream1.forEach(System.out::println);

        System.out.println("특정 범위의 정수");
        IntStream intStream5 = IntStream.range(1, 5); // end 는 포함되지 않음
        IntStream intStream6 = IntStream.rangeClosed(1, 5); // end 포함
        intStream5.forEach(System.out::println);
        intStream6.forEach(System.out::println);

        // 난수를 생성하는 Random class의 인스턴스 메서드(인스턴스를 생성해야 사용할 수 있는 메서드)를 사용하여 난수로 이루어진 스트림을 반환
        // 이 메서드들이 반환하는 스트림은 무한 스트림 이므로 limit을 함께 사용
        IntStream intStream7 = new Random().ints().limit(5); // int 타입의 난수로 이루어진 IntStream을 반환
        System.out.println("Random IntStream");
        intStream7.forEach(System.out::println);
        LongStream longStream1 = new Random().longs(5); // long 타입의 난수로 이루어진 LongStream을 반환
        System.out.println("Random LongStream");
        longStream1.forEach(System.out::println);
        System.out.println("지정된 범위의 난수를 발생시키는 IntStream");
        IntStream intStream8 = new Random().ints(5,0, 200); // limit 대신 매개변수로 크기 정해줌
        intStream8.forEach(System.out::println);

        // 람다식 - iterate(), generate()는 기본형 스트림 타입의 참조변수로 다룰 수 없다.
        System.out.println("람다식 - iterate() : 람다식을 매개변수로 받아서, 이 람다식에 의해 계산되는 값들을 요소로하는 무한 스트림 발생시킴");
        Stream<Integer> lambdaStream = Stream.iterate(0, (n) -> n + 2).limit(5); // seed: 시작 값
        lambdaStream.forEach(System.out::println);
        System.out.println("람다식 - generate() : iterate()와 달리, 이전 결과를 이용해서 다음 요소를 계산하지 않음");
        Stream<Integer> oneStream = Stream.generate(() -> 1).limit(5);
        oneStream.forEach(System.out::println);

        Stream emptyStream = Stream.empty();
        System.out.println("Empty Stream's count(length) : " + emptyStream.count());

        System.out.println("두 스트림의 연결 - concat()"); // concat()은 Stream의 static 메서드
        String[] str1 = {"123", "456", "789"};
        String[] str2 = {"abc", "def", "ghi"};

        Stream<String> strStream5 = Stream.of(str1);
        Stream<String> strStream6 = Arrays.stream(str2);
        Stream<String> concatStrStream = Stream.concat(strStream5, strStream6);
        concatStrStream.forEach(System.out::println);


    }
}
