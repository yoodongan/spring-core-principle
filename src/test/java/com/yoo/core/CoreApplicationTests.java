package com.yoo.core;

import com.yoo.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {
    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    @Test
    void join() {
        //given
        Member member = new Member(1, "spring", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1);

        //then
        Assertions.assertThat(findMember).isEqualTo(member);
    }



}
