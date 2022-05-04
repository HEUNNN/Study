package ch14;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class StreamEx8 {
    public static void main(String[] args) {
        StudentInfo[] stuArr = {
                new StudentInfo("나자바", true, 1, 1, 300),
                new StudentInfo("김지미", false, 1, 1, 250),
                new StudentInfo("김자바", true, 1, 1, 200),
                new StudentInfo("이지미", false, 1, 2, 150),
                new StudentInfo("남자바", true, 1, 2, 100),
                new StudentInfo("안지미", false, 1, 2, 50),
                new StudentInfo("황지미", false, 1, 3, 100),
                new StudentInfo("강지미", false, 1, 3, 150),
                new StudentInfo("이자바", true, 1, 3, 200),

                new StudentInfo("나자바", true, 2, 1, 300),
                new StudentInfo("김지미", false, 2, 1, 250),
                new StudentInfo("김자바", true, 2, 1, 200),
                new StudentInfo("이지미", false, 2, 2, 150),
                new StudentInfo("남자바", true, 2, 2, 100),
                new StudentInfo("안지미", false, 2, 2, 50),
                new StudentInfo("황지미", false, 2, 3, 100),
                new StudentInfo("강지미", false, 2, 3, 150),
                new StudentInfo("이자바", true, 2, 3, 200),
        };
        System.out.println("1. 단순분할 (성별로 분할)");
        Map<Boolean, List<StudentInfo>> stuBySex = Stream.of(stuArr).collect(partitioningBy(StudentInfo::getIsMale));

        List<StudentInfo> maleStudent = stuBySex.get(true);
        List<StudentInfo> femaleStudent = stuBySex.get(false);

        System.out.println("Male Student");
        for (StudentInfo stu : maleStudent) System.out.println(stu);
        System.out.println("Female Student");
        for (StudentInfo stu : femaleStudent) System.out.println(stu);

        System.out.println();
        System.out.println("2. 단순분할 + 통계(성별 당 학생수)");
        Map<Boolean, Long> stuNumbySex = Stream.of(stuArr).collect(partitioningBy(StudentInfo::getIsMale, counting()));
        System.out.println("남학생 수: " + stuNumbySex.get(true));
        System.out.println("여학생 수: " + stuNumbySex.get(false));

        System.out.println();
        System.out.println("3. 단순분할 + 통계(성별 1등)");
        Map<Boolean, Optional<StudentInfo>> topScoreBySex = Stream.of(stuArr).collect(partitioningBy(StudentInfo::getIsMale, maxBy(comparingInt(StudentInfo::getScore))));
        // maxBy()의 반환타입은 Optional<T> 이다.
        System.out.println("남학생 1등: " + topScoreBySex.get(true));
        System.out.println("여학생 1등: " + topScoreBySex.get(false));

        Map<Boolean, StudentInfo> topScroeBySex2 = Stream.of(stuArr).collect(partitioningBy(StudentInfo::getIsMale, collectingAndThen(maxBy(comparingInt(StudentInfo::getScore)), Optional::get)));
        System.out.println("collectingAndThen 사용");
        System.out.println("남학생 1등: " + topScroeBySex2.get(true));
        System.out.println("여학생 1등: " + topScroeBySex2.get(false));

        System.out.println();
        System.out.println("4. 다중분할(성별 불합격자, 100점 이하) - 이중분할 사용");
        Map<Boolean, Map<Boolean, List<StudentInfo>>> failedStuBySex = Stream.of(stuArr).collect(partitioningBy(StudentInfo::getIsMale, partitioningBy(s -> s.getScore() <= 100)));
        // s -> s.getScore() <= 100 의 반환값인 Boolean이 이중 분할에서 두번째 분할의 key로 사용됨, value는 그에 해당하는 StudentInfo List
        List<StudentInfo> failedMaleStu = failedStuBySex.get(true).get(true);
        List<StudentInfo> failedFemaleStue = failedStuBySex.get(false).get(true);

        for (StudentInfo s : failedMaleStu) System.out.println("Failed Male Student: " + s);
        for (StudentInfo s : failedFemaleStue) System.out.println("Failed Femail Student: " + s);


    }
}
class StudentInfo {
    String name;
    boolean isMale;
    int grade;
    int ban;
    int score;

    public StudentInfo(String name, boolean isMale, int grade, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.grade = grade;
        this.ban = ban;
        this.score = score;
    }
    public String getName() { return name; }
    public boolean getIsMale() { return isMale; }
    public int getGrade() { return grade; }
    public int getBan() { return ban; }
    public int getScore() { return score; }

    public String toString() {
        return String.format("[%s, %s, %d학년, %d반, %3d점]", name, isMale, grade, ban, score);
    }

    // groupingBy() 에서 사용
    enum Level { HIGH, MID, LOW } // 성적(Score)은 상, 중, 하 단계로 분류
}