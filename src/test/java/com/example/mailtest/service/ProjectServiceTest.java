package com.example.mailtest.service;

import com.example.mailtest.dto.request.ProjectCreateRequest;
import com.example.mailtest.entity.Member;
import com.example.mailtest.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    ProjectService projectService;

    @Autowired
    private MemberRepository memberRepository;

    private Long member1Id;
    private Long member2Id;
    private Long member3Id;

    @BeforeEach
    void setUp() {
        Member member1 = memberRepository.save(
                Member.builder()
                        .name("홍길동")
                        .email("abc@gmail.com")
                        .build()
        );

        Member member2 = memberRepository.save(
                Member.builder()
                        .name("신짱구")
                        .email("def@gmail.com")
                        .build()
        );

        Member member3 = memberRepository.save(
                Member.builder()
                        .name("봉미선")
                        .email("ghi@gmail.com")
                        .build()
        );

        member1Id = member1.getMemberId();
        member2Id = member2.getMemberId();
        member3Id = member3.getMemberId();
    }

    @Test
    void 프로젝트_생성_3명() throws Exception {
        List<Long> memberIdRequest = new ArrayList<>();
        memberIdRequest.add(member1Id);
        memberIdRequest.add(member2Id);
        memberIdRequest.add(member3Id);

        ProjectCreateRequest request = ProjectCreateRequest.builder()
                .title("신규 프로젝트 제목")
                .content("신규 프로젝트입니다.")
                .memberIdList(memberIdRequest)
                .build();

        projectService.createProject(request);

        Thread.sleep(100000);
    }

    @Test
    void 프로젝트_생성_100명() throws Exception {
        List<Long> memberIdRequest = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            memberIdRequest.add(member1Id);
        }

        ProjectCreateRequest request = ProjectCreateRequest.builder()
                .title("신규 프로젝트 제목")
                .content("신규 프로젝트입니다.")
                .memberIdList(memberIdRequest)
                .build();

        projectService.createProject(request);

        Thread.sleep(100000);
    }
}
