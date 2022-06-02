package hello.springmvc.basic;

import lombok.Data;

@Data // Lombok으로 @Getter, @Setter, @ToString, @EqualAndHashCode, @RequiredArgsConstructor를 자동으로 적용해준다.
public class HelloData {
    private String username;
    private int age;
}
