package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        // paramMap은 request에 담겨있는 정보(username, age) 등을 그저 사용할 수 있도록 넘겨줄 뿐, model에 저장되어있어서 view에 활용할 단계는 아니다.
        /*
        * paramMap에서 사용할 username, age와 같은 값을 꺼낸다. 그 값을 가지고 비지니스 로직 실행하고, model에 값을 넣어주고 문자열을 return해준다.
        * */

        // 비지니스 로직 시작
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);
        // 비지니스 로직 끝

        // model에 put
        model.put("member", member);

        return "save-result";
    }
}
