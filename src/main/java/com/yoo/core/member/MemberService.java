package com.yoo.core.member;

public interface MemberService {
    void join(Member member);

    Member findMember(long id);

}
