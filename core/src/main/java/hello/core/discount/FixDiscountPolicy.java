package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) { // 할인 된 금액을 반환하는 method
        if(member.getGrade() == Grade.VIP) { // enum은 '==' 사용
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
