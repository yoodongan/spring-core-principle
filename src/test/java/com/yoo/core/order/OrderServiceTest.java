package com.yoo.core.order;

import com.yoo.core.AppConfig;
import com.yoo.core.member.Grade;
import com.yoo.core.member.Member;
import com.yoo.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    OrderService orderService;
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    @DisplayName("주문 테스트")
    public void createOrder() {
        //given
        Member member = new Member(1L, "summer", Grade.VIP);
        //when
        memberService.join(member);
        Order order = orderService.createOrder(1L, "springboot", 10000);
        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}