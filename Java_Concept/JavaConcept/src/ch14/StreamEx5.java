package ch14;

import java.util.*;

public class StreamEx5 {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(s -> s.length());
        System.out.println("optStr = " + optStr.get());
        System.out.println("optInt = " + optInt.get());

        Optional<Integer> intRes = Optional.of("123").filter(x -> x.length() > 0).map(Integer::parseInt);
        int result1 = intRes.get(); // 123
        int result2 = Optional.of("").filter(x -> x.length() > 0).map(Integer::parseInt).orElse(-1);
        // orElse(): Optional 객체에서 값을 가져올 때 값이 null 일 때를 대비하여 대체 값을 지정한다.
        System.out.println("result1 = " + result1 + ", result2 = " + result2);

        // ifPresent() : Optional 객체의 값이 null이면 아무일이 일어나지 않고, 값이 있으면 람다식을 수행한다.
        Optional.of("456")
                .map(((x) -> Integer.parseInt(x))) // Integer::parseInt와 람다식은 같은 의미
                .ifPresent((i) -> System.out.printf("result3 = %d%n", i));

        OptionalInt optInt1 = OptionalInt.of(0); // 0을 저장
        OptionalInt optInt2 = OptionalInt.empty(); // 빈 객체를 생성

        // isPresent(): OptionalInt class의 인스턴스 변수로, 값이 저장되어 있는지에 대한 여부를 boolean으로 반환
        System.out.println(optInt1.isPresent()); // true
        System.out.println(optInt2.isPresent()); // false -> getAsInt() 사용시 예외 발생

        System.out.println(optInt1.getAsInt());
        System.out.println("optInt1 = " + optInt1);
        System.out.println("optInt2 = " + optInt2);
        System.out.println("optInt1.equals(optInt2) ? " + optInt1.equals(optInt2)); // false

        Optional<String> optStr1 = Optional.ofNullable(null); // null을 저장, null 저장 가능성이 예상되면 of 대신 ofNullable 사용
        Optional<String> optStr2 = Optional.empty(); // 빈 객체 생성
        System.out.println("optStr1 = " + optStr1);
        System.out.println("optStr2 = " + optStr2);
        System.out.println("optStr1.equals(optStr2) ? " + optStr1.equals(optStr2)); // true

        int result3 = optStrToInt(Optional.of("123"), 0);
        int result4 = optStrToInt(Optional.of(""), 0);

        System.out.println("result3 = " + result3); // 123
        System.out.println("result4 = " + result4); // 0
    }
    static int optStrToInt(Optional<String> optStr, int defaultValue) {
        try {
            return optStr.map(Integer::parseInt).get();
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
