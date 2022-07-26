package restfulAPI.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestController 는 view 이름을 반환하는 것이 아니다. 그냥 String 이다.
public class HelloWorldController {

    // String을 반환하는 API
    // Method: GET, URI: /hello-world
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello world";
    }
}
