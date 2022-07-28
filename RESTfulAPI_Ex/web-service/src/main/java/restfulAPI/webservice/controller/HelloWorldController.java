package restfulAPI.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController // RestController 는 view 이름을 반환하는 것이 아니다. 그냥 String 이다.
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

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
    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) { // http://localhost:8080/hello-world-bean/path-variable/Jenny
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    // @RequestParam 사용
    @GetMapping("/hello-world-bean/request-param")
    public HelloWorldBean helloWorldBean2(@RequestParam("message") String message) { // http://localhost:8080/hello-world-bean/request-param?message=hello-world
        return new HelloWorldBean(message);
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) { // Locale 값은 RequestHeader 값에 의해 전달 받을 수 있다.
        // MessageSource 객체를 사용해서 메시지 값을 반환할 수 있다.
        return messageSource.getMessage("greeting.message", null, locale);
    }
}
