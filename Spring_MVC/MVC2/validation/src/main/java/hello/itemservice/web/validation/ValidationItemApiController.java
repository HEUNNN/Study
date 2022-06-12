package hello.itemservice.web.validation;

import hello.itemservice.web.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {

    @PostMapping("/add") // HTTP 요청 메시지 바디는 JSON 형태로 올것이다.
    public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult) {
        log.info("API 컨트롤러 호출");

        if (bindingResult.hasErrors()) {
            log.info("검증 오류 발생 errors = {}", bindingResult);
            return bindingResult.getAllErrors(); // @RestController를 사용하면 @ResponseBody의 역할도 해주기 때문에, 오류가 발생하여 bindingResult.getAllErrors()가 view name이 되지 않고 HTTP응답 바디 메시지로 들어간다.
        }

        log.info("성공 로직 실행");
        return form;
    }
}
