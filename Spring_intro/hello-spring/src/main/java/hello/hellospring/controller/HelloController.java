package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello") // Web에서 '/hello'가 들어오면 hello 메서드를 호출한다.
    public String hello(Model model) { // Spring이 모델을 만들어서 넘겨준다.
        // Model은 MVC의 Model을 의미한다.
        model.addAttribute("data", "Spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // 외부에서 이름을 받아온다. hello는 내부에서 직접 data를 넣어준다.
    public String helloMVC(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
}
