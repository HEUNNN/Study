package restfulAPI.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration // Config 용도의 빈을 등록한다는 것을 의미한다.
@EnableSwagger2
public class SwaggerConfig { // Swagger 설정 파일

    @Bean
    public Docket api() { // api와 관련된 Documentation을 만들어서 반환해준다.
        return new Docket(DocumentationType.SWAGGER_2);
    }

}
