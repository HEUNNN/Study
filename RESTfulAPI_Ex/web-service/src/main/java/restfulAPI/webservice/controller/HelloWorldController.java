package restfulAPI.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestController 는 view 이름을 반환하는 것이 아니다. 그냥 String 이다.
public class HelloWorldController {

    // String을 반환하는 API
    // Method: GET, URI: /hello-world
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello world";
    }

    // Java Bean 을 반환하는 API → 그냥 String 이 아닌, JSON 형태로 반환이 될 것이다.
    // 기본적인 String 형태가 아닌 java 객체 형태로 반환하게 되면 스프링이 JSON 형태로 변환해서 반환해주는 기능을 제공해준다.
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello-world");
    }

    // @PathVariable 사용
    @GetMapping("/hello-world-bean1/{message}")
    public HelloWorldBean helloWorldBean(@PathVariable String message) { // http://localhost:8080/hello-world-bean1/hello-world
        return new HelloWorldBean(message);
    }

    // @RequestParam 사용
    @GetMapping("/hello-world-bean2")
    public HelloWorldBean helloWorldBean2(@RequestParam("message") String message) { // http://localhost:8080/hello-world-bean2?message=hello-world
        return new HelloWorldBean(message);
    }
}
