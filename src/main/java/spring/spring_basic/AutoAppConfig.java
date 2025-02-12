package spring.spring_basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        basePackages = "spring.spring_basic.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)// AppConfig를 제외하기 위해 excludeFilters를 사용한다.

public class AutoAppConfig {

}
