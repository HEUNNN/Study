package ch14;
import java.util.*;
import java.util.stream.*;

public class StreamEx3 {
    public static void main(String[] args) {
        Student[] stuArr = {
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        };
        Stream<Student> stuStream = Stream.of(stuArr);

        stuStream.sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println); // Stream 소모

        stuStream = Stream.of(stuArr); // stream 다시 생성 -> 소모되었기 때문에
        IntStream stuScoreStream = stuStream.mapToInt(Student::getTotalScore); // Stream<Student> -> IntStream으로 변환 , mapToInt 사용
        IntSummaryStatistics stat = stuScoreStream.summaryStatistics(); // sum(), average()등의 최종 연산으로 인해 stream이 소모되는 불편함을 해소하기 위해 summaryStatistics() 메서드를 사용한다.
        System.out.println("count = " + stat.getCount());
        System.out.println("sum = " + stat.getSum());
        System.out.printf("average = %.2f%n", stat.getAverage());
        System.out.println("min = " + stat.getMin());
        System.out.println("max = " + stat.getMax());
    }
}
