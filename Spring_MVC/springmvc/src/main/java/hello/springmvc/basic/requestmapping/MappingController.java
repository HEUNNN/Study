package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

//    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    @GetMapping("/mapping-get-v2")
    public String helloBasic() {
        log.info("basic");
        return "HTTP method mapping 축약 OK";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) { // url이 /mapping/userLee 이런식으로 들어오면 data = userlee가 된다.
        log.info("mapping Path = {}", data);
        return "PathVariable OK";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
        log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
        return "다중 PathVariable OK";
    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "특정 파라미터 조건 매핑";

        // ?mode=debug가 없으면 bad request -> 매핑 자체가 되지 않
    }

    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "특정 헤더 조건 매핑";
    }

    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    // Http request Header의 contentType이 application/json으로 되어야 매핑 성공
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "미디어 타입 조건 매핑 - HTTP 요청 Content-type, consume";
    }

    @PostMapping(value = "mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "미디어 타입 조건 매핑 - HTTP 요청 Accept, produce";
    }
}
