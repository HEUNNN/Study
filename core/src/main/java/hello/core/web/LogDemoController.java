package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor // Lombok에 의해 생성자도 자동으로 생성되고 DI도 자동으로 된다. (@Autowired가 붙은 생성자가 없어도 DI가 이루어지고 있다.)
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
       String requestURL =  request.getRequestURL().toString(); // 고객이 어떤 URL로 요청을 했는지 알 수 있다.

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId"); // 이미 uuid, url은 생성되어 있고 testId만 붙여서 출력된다.
        return "OK";
    }
}
