package com.example.mailtest.event;

import com.example.mailtest.dto.request.MailSendRequest;
import com.example.mailtest.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProjectCreateEventListener {

    private final MailService mockMailService;

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void sendMail(ProjectCreateEvent projectCreateEvent) {
        log.info("sendMail 실행");

        projectCreateEvent.getEmailList().forEach(email -> {
            mockMailService.sendMailAsync(MailSendRequest.builder()
                    .email(email)
                    .title("[" + projectCreateEvent.getProjectTitle() + "] 프로젝트에 초대되었습니다.")
                    .content("안녕하세요. " + projectCreateEvent.getProjectTitle() + "에 초대되었습니다 !")
                    .build());
        });
    }
}
