package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //ComponentScan은 수동으로 등록하는 건데 @Configuration이 붙은 AppConfig가 자동으로 등록되면 안된다.
)
public class AutoAppConfig {
    // 의존 관계를 주입하는 코드를 AppConfig 처럼 직접 작성하지 않고, MemberServiceImpl 등에서 @Autowired를 사용하여 자동으로 의존 관계를 주입한다.
}
