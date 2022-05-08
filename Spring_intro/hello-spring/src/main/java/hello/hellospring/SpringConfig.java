package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    private DataSource dataSource;

//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) { // Injection하면 , Spring Data JPA가 만든 구현체가 등록이 된다.
        // Spring 컨테이너에서 MemberRepository를 찾는데, Spring Data JPA로 만든 SpringDataJpaMemberRepository는 spring data jpa 기능으로
        // 자동으로 컨테이너, 즉 스프링 빈에 등록하기 때문에 따로 @Bean 하지 않아도 MemberRepository를 Injection 받을 수 있다.
        this.memberRepository = memberRepository;
    }


    @Bean // Spring Bean 등록 -  코드로 직접하기
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//
//        return new MemoryMemberRepository();
//        return new JdbcMemoryRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//
//    }
}
