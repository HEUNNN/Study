package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    @DisplayName("Config 싱글톤 테스트")
    void configSingletonTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberServiceImpl = ac.getBean("memberService", MemberServiceImpl.class); // getMemberRepository()는 MemberService 인터페이스에는 정의되어 있지 않아서 반환 타입을 Impl로 함
        MemberRepository memberRepository1 = memberServiceImpl.getMemberRepository();
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("membserService -> memberRepository: " + memberRepository1);
        System.out.println("orderService -> memberRepository: " + memberRepository2);
        System.out.println("original memberRepository in AppConfig: " + memberRepository);
        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);


    }
}
