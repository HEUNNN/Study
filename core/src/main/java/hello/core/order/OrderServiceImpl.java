package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    // 주문 서비스 구현체의 역할

    // 1. 회원 저장소 구현체에 회원을 조회
    private final MemberRepository memberRepository;
    // 2. 할인 정책 구현체에 할인적용을 조회
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;

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
