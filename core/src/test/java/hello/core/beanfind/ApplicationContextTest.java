package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {
    // 컨테이너에 등록된 모든 빈 조회
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName); // type을 모르기 때문에 Object type으로 받
            System.out.println("Bean name: " + beanDefinitionName + ", Bean object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기 - 내가 만든 bean 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // getBeanDefinition(beanDefinitionName): bean 하나 하나에 대한 meta 데이터 정보

            // Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) { // ROLE_APPLICATION: 내가 애플리케이션 개발을 위해 등록한 빈을 의미
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("Bean name: " + beanDefinitionName + ", Bean object = " + bean);
            }
        }
    }
}
