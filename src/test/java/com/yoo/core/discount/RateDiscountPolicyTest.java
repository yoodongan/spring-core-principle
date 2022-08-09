package com.yoo.core.discount;

import com.yoo.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    @Test
    @DisplayName("VIP 는 10% 할인 적용")
    void discount() {
        //given
        Member member = new Member(1, "spring", Grade.VIP);
        //when
        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        int discountPrice = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP가 아닐 때 할인 적용이 되지 않는다.")
    void noDiscount() {
        //given
        Member member = new Member(2, "spring", Grade.BASIC);
        //when
        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        int discountPrice = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discountPrice).isEqualTo(0);

    }

}