package restfulAPI.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Configuration // Config 용도의 빈을 등록한다는 것을 의미한다.
@EnableSwagger2
public class SwaggerConfig { // Swagger 설정 파일

    // Swagger Cutomizing
    private static final Contact DEFAULT_CONTACT = new Contact("Hye Lee", "https://www.naver.com/", "abe@naver.com");
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API Title", "My User management REST API Service",
            "1.0", "urn:tos", DEFAULT_CONTACT,
            "Apache 2.0", "https://namu.wiki/w/%EC%95%84%ED%8C%8C%EC%B9%98", new ArrayList<>());
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json", "application/xml"));

    @Bean
    public Docket api() { // api와 관련된 Documentation을 만들어서 반환해준다.
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

}
