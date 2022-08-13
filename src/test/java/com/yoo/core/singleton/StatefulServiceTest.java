package com.yoo.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {
    static class StatefulTest{
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
//    @Test
//    @DisplayName("StatefulService 싱글톤 테스트")
//    void test() {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulTest.class);
//        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
//        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);
//        statefulService1.order("Park", 10000);
//        statefulService2.order("Park", 20000);
//        // 사용자 주문금액 확인!
//        int price1 = statefulService1.getPrice();
//        int price2 = statefulService2.getPrice();
//
//        System.out.println(price1);
//        System.out.println(price2);
//        Assertions.assertThat(price1).isEqualTo(price2);   // 이렇게 설계하면 안된다.
//    }
    @Test
    @DisplayName("서로 공유하는 변수 개념을 삭제")
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulTest.class);
        StatefulService stetefulService1 = ac.getBean(StatefulService.class);
        StatefulService stetefulService2 = ac.getBean(StatefulService.class);

        int priceA = stetefulService1.order("spring", 1000);
        int priceB = stetefulService2.order("summer", 2000);

        Assertions.assertThat(priceA).isNotEqualTo(priceB);
    }


}
