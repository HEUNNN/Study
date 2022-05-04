package ch14;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class StreamEx7 {
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

        // 학생 이름만 뽑아서 List<String>에 저장
        List<String> names = Stream.of(stuArr).map(s -> s.getName()).collect(Collectors.toList());
        System.out.println(names);
        System.out.println();

        // stream을 배열로 변환
        Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);
        for(Student s : stuArr2) {
            System.out.println(s);
        }
        System.out.println();

        // stream을 Map<String, Student>로 변환 -> 학생 이름이 key
        Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap((s) -> s.getName(), stu -> stu));
        System.out.println("keySet: " + stuMap.keySet());
        for (String stuName : stuMap.keySet()) {
            System.out.println("key: " + stuName + ", value: " + stuMap.get(stuName));
        }
        System.out.println();

        long count = Stream.of(stuArr).collect(counting());
        long totalScore = Stream.of(stuArr).collect(summingInt(s -> s.getTotalScore()));
        System.out.println("count: " + count);
        System.out.println("total score: " + totalScore);
        System.out.println();

        totalScore = Stream.of(stuArr).collect(reducing(0, Student::getTotalScore, Integer::sum));
        System.out.println("totla score: " + totalScore);

        Optional<Student> topStudent = Stream.of(stuArr).collect(maxBy(Comparator.comparingInt(Student::getTotalScore)));
        System.out.println("top student: " + topStudent.get());
        System.out.println();

        IntSummaryStatistics stat = Stream.of(stuArr).collect(summarizingInt(Student::getTotalScore));
        System.out.println(stat);
        System.out.println();

        String stuNames = Stream.of(stuArr).map(Student::getName).collect(joining(", ", "{ ", " }"));
        System.out.println(stuNames);
    }
}
