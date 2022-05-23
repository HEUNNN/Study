package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HelloData {

    // JSON 형식으로 파싱하기 위한 클래스
    private String username;
    private int age;

}
