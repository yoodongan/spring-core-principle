package com.yoo.core.order;

import com.yoo.core.AppConfig;
import com.yoo.core.member.Grade;
import com.yoo.core.member.Member;
import com.yoo.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "spring", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "chicken", 10000);
        System.out.println(order.toString());
    }

}
