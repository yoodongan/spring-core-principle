package com.yoo.core.member;

import com.yoo.core.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    @DisplayName("회원가입 테스트")
    void join() {
        //given
        Member member = new Member(1, "winter", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1);
        //then
        assertThat(findMember).isEqualTo(member);
    }
}