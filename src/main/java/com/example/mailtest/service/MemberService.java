package com.example.mailtest.service;

import com.example.mailtest.dto.request.MemberCreateRequest;
import com.example.mailtest.dto.response.MemberCreateResponse;
import com.example.mailtest.entity.Member;
import com.example.mailtest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateResponse createMember(MemberCreateRequest request) {
        Member savedMember = memberRepository.save(Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build());

        return MemberCreateResponse.builder()
                .savedId(savedMember.getMemberId())
                .build();
    }
}
