package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello") // web app에서 '/hello'가 들어오면 hello(Model model) method가 호출 된다.
    public String hello(Model model) { // Spring이 모델을 만들어서 넣어준다.
        model.addAttribute("data", "Hello Spring"); // key: "data", value: "Hello Spring"
        return "hello"; // templates/hello.html을 의미
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API
    @GetMapping("/hello-string")
    @ResponseBody // HTTP의 body 부분에 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name; // Template Engine과 달리 return 한 text가 그대로 내려간다.(View X) 웹 페이지 소스를 확인해보면 html로 구성되어 있지 않다.
    }
    // 데이터를 요구할때 유용하게 사용된다. -> API
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체를 넘긴다. -> JSON 방식으로 출력됨
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
