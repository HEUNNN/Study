package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // Web에서 '/hello'가 들어오면 hello 메서드를 호출한다.
    public String hello(Model model) { // Spring이 모델을 만들어서 넘겨준다.
        // Model은 MVC의 Model을 의미한다.
        model.addAttribute("data", "Spring!!");
        return "hello";
    }
    // MVC
    @GetMapping("hello-mvc") // 외부에서 이름을 받아온다. hello는 내부에서 직접 data를 넣어준다.
    public String helloMVC(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    // API -> Model 사용 X, View가 없고 반환되는 문자(data)가 그대로 웹에 내려간다.(소스코드를 보면 MVC와 차이를 확인해볼 수 있다.)
    @GetMapping("hello-string")
    @ResponseBody // HTTP의 body에 return 한 데이터를 직접 넣겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api") // JSON 방식이다.
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){ // Type이 Hello인 값을 반환하는 메서드
        Hello hello = new Hello(); // 객체를 생성(new)해야 그 자신(this)의 name에 param으로 넘겨받은 name을 set할 수 있다.
        hello.setName(name);
        return hello;
    }
    static class Hello { // static class는 같은 클래스 안에서 사용할 수 있다.
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
