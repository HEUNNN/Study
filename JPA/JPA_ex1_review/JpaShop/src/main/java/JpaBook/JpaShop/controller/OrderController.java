package JpaBook.JpaShop.controller;

import JpaBook.JpaShop.domain.Member;
import JpaBook.JpaShop.domain.item.Item;
import JpaBook.JpaShop.service.ItemService;
import JpaBook.JpaShop.service.MemberService;
import JpaBook.JpaShop.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model) {

        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

/*    @PostMapping("/order")
    public String order(@ModelAttribute("dto") OrderDTO dto) { // DTO와 ModelAttribute 사용

        orderService.order(dto.getMemberId(), dto.getItemId(), dto.getCount());
        return "redirect:/orders";
    }*/

    @PostMapping("/order")
    public String order(@RequestParam("memberId") Long memberId, @RequestParam("itemId") Long itemId, @RequestParam("count") int count) { // RequestParam 사용, HTML Form으로 넘어오는 데이터도 HTTP 요청 파라미터처럼 동작하기 때문에 RequestParam 사용 가능

        // TX(트랜잭션) 없는 외부인 이곳에서 멤버 엔티티 인스턴스를 조회해서 order로 넘겨주면, 그 엔티티 인스턴스는 JPA와 아무 연관이 없다.
        orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }
}
