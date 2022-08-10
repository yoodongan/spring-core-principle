package com.yoo.core;

import com.yoo.core.discount.DiscountPolicy;
import com.yoo.core.discount.RateDiscountPolicy;
import com.yoo.core.member.MemberRepository;
import com.yoo.core.member.MemberService;
import com.yoo.core.member.MemberServiceImpl;
import com.yoo.core.member.MemoryMemberRepository;
import com.yoo.core.order.OrderService;
import com.yoo.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
