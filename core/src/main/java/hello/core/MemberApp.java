package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp { // Test 대신
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // AppConfig 직접 생성하고 사용하지 않고, Spring을 사용하기
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig의 @Bean에 딸려있는 것들을 스프링 컨테이너로 가져와 관리한다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // AppConfig에 정의된 메서드 이름 = getBean(name,return type)에서 name

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member name = " + memberA.getName());
        System.out.println("find member name = " + findMember.getName());
    }
}
