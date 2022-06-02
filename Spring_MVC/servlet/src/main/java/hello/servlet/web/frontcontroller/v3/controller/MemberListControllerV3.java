package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        // memberlist는 memberRepository(저장소)에서 members 값들을 꺼내면 된다. request.getparameter() 혹은 paramMap에서 username, age를 꺼낼 필요가 없다.
        List<Member> members = memberRepository.findAll();
        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", members); // ModelView에서 Map<String, Object>라서 List type도 Object(가장 root)로 받을 수 있다.
        return modelView;
    }
}
