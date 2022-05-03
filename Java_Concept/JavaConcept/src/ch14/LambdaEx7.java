package ch14;

import java.util.function.*;

public class LambdaEx7 {
    public static void main(String[] args) {
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);

        Function<String, String> h = f.andThen(g); // f-> g -> h
        Function<Integer, Integer> h2 = f.compose(g); // g -> f -> h

        // 어쨌든 h, h2는 합성 람다식, 즉 람다식이다. Function 함수형 인터페이스의 method apply를 사용
        System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2)); // 2 -> "10" -> 16

        Function<String, String > f2 = x -> x; // 항등 함수를 의미하는 람다식
        System.out.println(f2.apply("AA"));

        Predicate<Integer> p = i -> i < 100; // Predicate는 조건식을 나타내며 반환타입은 boolean
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate(); // i >= 100

        Predicate<Integer> all = notP.and(q);
        System.out.println(all.test(150)); // true
        System.out.println(all.test(310)); // false
        all.or(r);
        System.out.println(all.test(310)); // true
        System.out.println(all.test(311)); // false

        String str1 = "abc";
        String str2 = "abc";

        // str1과 str2가 같은지 비교한 결과를 반환
        boolean result = Predicate.isEqual(str1).test(str2); // isEqual()은 Predicate의 static method
        System.out.println(result); // true
    }
}
