package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaxInjectProviderTest {
    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int result1 = clientBean1.logic();
        assertThat(result1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int result2 = clientBean2.logic();
        assertThat(result2).isEqualTo(1);

        System.out.println("clientA's logic result: " + result1 + "clientB's logic result: " + result2);
    }

    @Scope("singleton")
    static class ClientBean {

        @Autowired
        private Provider<PrototypeBean> provider; // 필드 주입


        public int logic() {
            PrototypeBean prototypeBean = provider.get(); // getObject() 호출될 때 스프링 컨테이너에서 프로토타입 빈을 찾아서 반환해준다
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }
        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }
        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy " +this);
        }
    }

}

