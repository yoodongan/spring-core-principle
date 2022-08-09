package com.yoo.core.order;

import com.yoo.core.discount.DiscountPolicy;
import com.yoo.core.discount.FixDiscountPolicy;
import com.yoo.core.member.Grade;
import com.yoo.core.member.Member;
import com.yoo.core.member.MemberRepository;
import com.yoo.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
