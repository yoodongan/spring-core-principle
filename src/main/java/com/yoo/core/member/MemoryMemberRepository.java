package com.yoo.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> memberRepository = new HashMap<>();


    @Override
    public void save(Member member) {
        memberRepository.put(member.getId(), member);
    }

    @Override
    public Member findById(long id) {
        return memberRepository.get(id);
    }
}
