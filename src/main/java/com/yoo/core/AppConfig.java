package com.yoo.core;

import com.yoo.core.discount.FixDiscountPolicy;
import com.yoo.core.member.MemberService;
import com.yoo.core.member.MemberServiceImpl;
import com.yoo.core.member.MemoryMemberRepository;
import com.yoo.core.order.OrderService;
import com.yoo.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
