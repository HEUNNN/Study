package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
// Lombok의 annotaion으로 final(필수값을 의미)가 붙은 값들을 갖고 OrderServiceImpl(MemberRepositoru memberRepository, DiscountPolicy discountPolicy)와 같은 생성자를 자동으로 생성해준다.(생성자 필요없어짐)
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 생성자가 1개면 @Autowired 생략 가능
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) { // 생성자 주입
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName,itemPrice, discountPrice);
        // 단일 체계 설계 규칙이 잘 지켜짐
    }

    // 주문 생성 서비스가 주문(Order)을 생성하여 반환한다.

    //Test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
