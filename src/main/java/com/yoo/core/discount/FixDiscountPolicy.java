package com.yoo.core.discount;

import com.yoo.core.member.Grade;
import com.yoo.core.member.Member;
import org.springframework.stereotype.Component;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountAmount = 1000;

    @Override
    public int discount(Member member, int price) {  // 추후 가격 대비 할인이 있을 수 있기 때문에 price 도 추가.
        if (member.getGrade() == Grade.VIP) {
            return discountAmount;
        } else {
            return 0;
        }
    }
}
