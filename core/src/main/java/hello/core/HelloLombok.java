package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    // Lombok 예시
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();

        helloLombok.setName("lee");
        String userName = helloLombok.getName();
        System.out.println("Username : " + userName);

        helloLombok.setAge(25);

        System.out.println(helloLombok.toString());
    }
}
