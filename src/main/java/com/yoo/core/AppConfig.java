package com.yoo.core;

import com.yoo.core.discount.DiscountPolicy;
import com.yoo.core.discount.RateDiscountPolicy;
import com.yoo.core.member.MemberRepository;
import com.yoo.core.member.MemberService;
import com.yoo.core.member.MemberServiceImpl;
import com.yoo.core.member.MemoryMemberRepository;
import com.yoo.core.order.OrderService;
import com.yoo.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
