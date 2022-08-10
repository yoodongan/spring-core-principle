package com.yoo.core.member;

import com.yoo.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // MemberApp 에서 회원 관련 기능들을 콘솔 창에 출력해본다.
        Member member = new Member(1, "summer", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1);
        System.out.println(findMember.toString());
    }

}
