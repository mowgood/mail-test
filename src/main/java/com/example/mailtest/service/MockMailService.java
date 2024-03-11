package com.example.mailtest.service;

import com.example.mailtest.dto.request.MailSendRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MockMailService implements MailService {

    @Override
    @Async("taskExecutor1")
    public void sendMailAsync(MailSendRequest request) {
        try {
            Thread.sleep(3000);
            log.info("MockMailService : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMailSync(MailSendRequest request) {
        log.info("Mock 동기 메일 전송");
    }
}
