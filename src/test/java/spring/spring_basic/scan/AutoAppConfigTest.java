package spring.spring_basic.scan;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.spring_basic.AutoAppConfig;
import spring.spring_basic.member.MemberService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
         AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
         MemberService memberService = ac.getBean(MemberService.class);
         assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
