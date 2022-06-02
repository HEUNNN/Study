package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class); // MemberService.class -> required type
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass()); // getClass(): 현재 참조하고 있는 클래스를 확인하는 메서드
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService가 MemberServiceImpl의 인스턴스이면 성공
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class); // MemberService.class -> required type
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass()); // getClass(): 현재 참조하고 있는 클래스를 확인하는 메서드
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService가 MemberServiceImpl의 인스턴스이면 성공
    }

    @Test
    @DisplayName("구체 타입으로 빈 조회 - 역할(인터페이스)에 의존해야하기 때문에 추천하지 않는 방법")
    void findBeanByType2() {
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xx", MemberService.class));
    }

}
