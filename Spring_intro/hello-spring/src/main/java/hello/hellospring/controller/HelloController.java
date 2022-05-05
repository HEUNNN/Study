package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello") // web app에서 '/hello'가 들어오면 hello(Model model) method가 호출 된다.
    public String hello(Model model) { // Spring이 모델을 만들어서 넣어준다.
        model.addAttribute("data", "Hello Spring"); // key: "data", value: "Hello Spring"
        return "hello"; // templates/hello.html을 의미
    }
}
