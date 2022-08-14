package com.yoo.core.test.scan.autowired;

import com.yoo.core.AutoAppConfig;
import com.yoo.core.discount.DiscountPolicy;
import com.yoo.core.member.Grade;
import com.yoo.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);

        Member member = new Member(1L, "spring", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "rateDiscountPolicy");
        Assertions.assertThat(discountPrice).isEqualTo(1000);

    }

    static class DiscountService{
        private Map<String, DiscountPolicy> policyMap;
        private List<DiscountPolicy> policyList;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;

            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }

    }




}
