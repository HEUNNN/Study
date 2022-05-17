package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycle() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(lifeCycleConfig.class);
        NetworkClient bean = ac.getBean(NetworkClient.class);
        ac.close(); // close() 사용을 위해서 ac의 타입을 AnnotationConfigApplicationContext로 바꿈
    }

    @Configuration
    static class lifeCycleConfig {
        @Bean
        public NetworkClient networkClient() { // networkClient() method가 호출 되고 반환된 결과가 bean으로 등록된다.
            NetworkClient nc = new NetworkClient();
            nc.setUrl("http://hello-spring.dev"); // 수정자 주입을 통한 DI
            return nc;
        }
    }
}
