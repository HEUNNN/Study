package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingletonTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A 사용자 10000 주문
        int price1 = statefulService1.order("userA", 10000);
        // ThreadB: B 사용자 20000 주문
        int price2 = statefulService2.order("userB", 20000);

//        ThreadA: A 사용자 주문 금액 조회
//        int price1 = statefulService1.getPrice(); // 10000
//        System.out.println("price1 = " + price1); // but 20000

//        ThreadB: B 사용자 주문 금액 조회
//        int price2 = statefulService2.getPrice(); // 20000
//
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

        System.out.println("price1 = " + price1 + ", price2 = " + price2);
        assertThat(price1).isEqualTo(10000);
        assertThat(price2).isEqualTo(20000);
    }
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}