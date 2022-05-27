package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// @Controller
@Component // component scan 대상이 되어서, spring 컨테이너에 스프링 빈으로 등록된다.
@RequestMapping // @Controller는 Component 스캔에 자동으로 인식이 되지만, @RequestMapping은 따로 @Component를 달아서 컴포넌트 스캔이 인식할 수 있도록 해야한다.
// 클래스 레벨에 @Controller 혹은 @RequestMapping이 있어야 매핑 정보로 인식된다.
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
