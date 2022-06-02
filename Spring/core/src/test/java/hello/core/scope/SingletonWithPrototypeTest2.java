package hello.core.scope;

import ch.qos.logback.core.net.server.Client;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest2 {
    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
        assertThat(prototypeBean).isInstanceOf(PrototypeBean.class); // Autowired가 잘 되었는지 확인

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        assertThat(clientBean1).isInstanceOf(ClientBean.class);
        int result1 = clientBean1.logic();
        System.out.println("clientA's logic result: " + result1);
        assertThat(result1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        assertThat(clientBean1).isInstanceOf(ClientBean.class);
        int result2 = clientBean2.logic();
        System.out.println("clientB's logic result: " + result2);
        assertThat(result2).isEqualTo(2);

    }

    static class ClientBean {
        private final PrototypeBean prototypeBean; // 생성시점에 주입

        @Autowired
        public ClientBean(PrototypeBean prototypeBean) { // 스프링 컨테이너에 빈으로 등록된것들 중 PrototypeBean type을 찾아 자동으로 주입 해준다. (Autowired 덕분)
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
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
