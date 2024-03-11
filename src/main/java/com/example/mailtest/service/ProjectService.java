package com.example.mailtest.service;

import com.example.mailtest.dto.request.MailSendRequest;
import com.example.mailtest.dto.request.ProjectCreateRequest;
import com.example.mailtest.dto.response.ProjectCreateResponse;
import com.example.mailtest.entity.Member;
import com.example.mailtest.entity.MemberProject;
import com.example.mailtest.entity.Project;
import com.example.mailtest.event.ProjectCreateEvent;
import com.example.mailtest.repository.MemberProjectRepository;
import com.example.mailtest.repository.MemberRepository;
import com.example.mailtest.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final MemberRepository memberRepository;

    private final MemberProjectRepository memberProjectRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    private final MailService mailService;

    @Transactional
    public ProjectCreateResponse createProject(ProjectCreateRequest request) {
        Project project = Project.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        // 프로젝트 생성
        Project savedProject = projectRepository.save(project);

        // 프로젝트 멤버 추가
        List<String> emailList = new ArrayList<>();
        request.getMemberIdList().forEach(memberId -> {
            Member member = memberRepository.findById(memberId).orElseThrow();
            memberProjectRepository.save(MemberProject.builder()
                    .member(member)
                    .project(project)
                    .build());

            /*
            mailService.sendMailSync(MailSendRequest.builder()
                    .email(member.getEmail())
                    .name(member.getName())
                    .title("[동기 메일]")
                    .content("동기 메일 입니다.")
                    .build());
             */

            emailList.add(member.getEmail());
        });

        // 프로젝트 생성 이벤트 발행
        log.info("projectCreateEvent 발행");
        applicationEventPublisher.publishEvent(ProjectCreateEvent.builder()
                .emailList(emailList)
                .projectTitle(project.getTitle())
                .build()
        );

        return ProjectCreateResponse.builder()
                .savedId(savedProject.getProjectId())
                .build();
    }
}
