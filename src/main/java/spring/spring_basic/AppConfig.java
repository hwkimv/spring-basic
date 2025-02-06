package spring.spring_basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring_basic.discount.DiscountPolicy;
import spring.spring_basic.discount.RateDiscountPolicy;
import spring.spring_basic.member.MemberService;
import spring.spring_basic.member.MemberServiceImpl;
import spring.spring_basic.member.MemoryMemberRepository;
import spring.spring_basic.order.OrderService;
import spring.spring_basic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    /**
     * @Bean memberService -> new MemoryMemberRepository()
     * @Bean orderService -> new MemoryMemberRepository()
     * 이렇게 되면 memberService와 orderService가 다른 MemoryMemberRepository를 사용하게 된다.
     * 이렇게 되면 싱글톤이 깨지는 것이다.

     * AppConfig에서 MemoryMemberRepository를 빈으로 등록하고, memberService와 orderService에 주입해주면
     * 같은 MemoryMemberRepository가 사용된다.
     * 이렇게 되면 싱글톤이 보장된다.
     */

    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository

    @Bean
    public MemberService memberService() {
        //1번
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        //2번
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        //3번
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
