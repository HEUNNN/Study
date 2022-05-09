package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /*
    * @return 할인 돤 금액
    * */
    int discount(Member member, int price);
}
