package com.yoo.core.discount;

import com.yoo.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
