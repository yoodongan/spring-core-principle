package com.yoo.core.discount;

import com.yoo.core.member.Grade;
import com.yoo.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy {
    private static int discountRate = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountRate/100;
        } else {
            return 0;
        }
    }
}
