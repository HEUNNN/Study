package JpaBook.JpaShop.controller;

import JpaBook.JpaShop.domain.Address;
import JpaBook.JpaShop.domain.Member;
import JpaBook.JpaShop.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm()); // 비어있는 MemberForm 객체를 model에 담아 보낸다. → validation 때 유용하게 사용된다.
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        // Member 엔티티를 바로 받지 않고, 회원가입 화면(form)에 적합한 도메인을 따로 만들어서 Member 엔티티에 매핑시킬 것이다.

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        // 여기서 실제 Member 엔티티와 MemberForm 객체를 매핑해준다.
        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }

}
