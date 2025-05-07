package com.company.test001.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    
    // 아이디 중복 확인
    public boolean isUsernameDuplicate(String username) {
        return memberRepository.findByUsername(username).isPresent();
    }

    // 회원가입
    public Member insertMember(Member member) {
    	member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberRepository.save(member);
    }

}
