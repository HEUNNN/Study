package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) { // frontController에서 paramMap을 넘겨주면서 호출한다.
        String username = paramMap.get("username"); // request.getParameter("username")을 해당 컨트롤러에서 하지 않고, frontController에서 paramMap을 넘겨주고 Controller에서는 request에서 찾는 것이 아닌 paramMap에서 찾는다.
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);


        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member); // Map type인 model을 ModelView 인스턴스에서 get해서 member값을 put 한다.

        return modelView;
    }
}
