package hello.core.scan.Filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
    // 컴포넌트 스캔에 추가할 custom Annotation
}
