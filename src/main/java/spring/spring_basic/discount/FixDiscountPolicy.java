package spring.spring_basic.discount;

import spring.spring_basic.member.Grade;
import spring.spring_basic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
        return 0;
        }
    }
}

