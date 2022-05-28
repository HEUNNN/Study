package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass()); // 사용대신 @Slf4j을 사용하면 자동으로 생성 -> Lombok에서 제공하는 기능

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace(" trace log={} ", name);
        log.debug(" debug log={} ", name);
        log.info(" info log={} ", name);
        log.warn(" warn log={} ", name);
        log.error(" error log={} ", name);

        return "ok";
    }
}
