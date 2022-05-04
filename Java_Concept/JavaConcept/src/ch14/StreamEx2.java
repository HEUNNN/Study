package ch14;

import java.io.*;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String[] args) {
        File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")};
        Stream<File> fileStream = Stream.of(fileArr);

        // map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<String> filenameStream = fileStream.map((s) -> s.getName()); // File::getName 과 같은 효과
        filenameStream.forEach(System.out::println);

        System.out.println();
        System.out.println("확장자만 추출하여 대문자로 변경 후 출력");
        fileStream = Stream.of(fileArr); // stream 다시 생성

        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.') != -1) // 확장자가 없는 것은 제외
                .map(s -> s.substring(s.indexOf('.') + 1)) // 확장자만 추출
                .map(String::toUpperCase)
                .forEach(System.out::print);
        System.out.println();
    }  
}
