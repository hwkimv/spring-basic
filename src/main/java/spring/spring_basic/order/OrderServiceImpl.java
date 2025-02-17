package spring.spring_basic.order;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.spring_basic.annotation.MainDisCountPolicy;
import spring.spring_basic.discount.DiscountPolicy;
import spring.spring_basic.member.Member;
import spring.spring_basic.member.MemberRepository;
import lombok.RequiredArgsConstructor;
/**
 * 주문 생성 서비스
 */
@Component
//@RequiredArgsConstructor // final 필드만 생성자 생성

public class OrderServiceImpl implements OrderService {

    @Getter
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,@MainDisCountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 정책에 따른 할인 금액 계산

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}

