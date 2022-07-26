package restfulAPI.webservice.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // message 를 세팅해주는 생성자를 만들어준다.
@NoArgsConstructor // default 생성자
public class HelloWorldBean {
    private String message;
}
