package com.example.mailtest.service;

import com.example.mailtest.dto.request.MemberCreateRequest;
import com.example.mailtest.dto.response.MemberCreateResponse;
import com.example.mailtest.entity.Member;
import com.example.mailtest.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 멤버_생성() throws Exception {
        //given
        MemberCreateRequest request = MemberCreateRequest.builder()
                .name("김철수")
                .email("jkl@gmail.com")
                .build();
        
        // when
        MemberCreateResponse response = memberService.createMember(request);
        Optional<Member> member = memberRepository.findById(response.getSavedId());

        // then
        assertEquals(response.getSavedId(), member.get().getMemberId());
        assertEquals("김철수", member.get().getName());
        assertEquals("jkl@gmail.com", member.get().getEmail());
    }
}
