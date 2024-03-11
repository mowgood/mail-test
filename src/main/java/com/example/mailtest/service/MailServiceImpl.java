package com.example.mailtest.service;

import com.example.mailtest.dto.request.MailSendRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Override
    @Async("taskExecutor1")
    public void sendMailAsync(MailSendRequest request) {
        log.info("비동기 메일 전송");
        log.info("이메일 : " + request.getEmail());
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(request.getEmail());
        mail.setSubject(request.getTitle());
        mail.setText(request.getContent());
//        javaMailSender.send(mail);
    }

    @Override
    public void sendMailSync(MailSendRequest request) {
        log.info("동기 메일 전송");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(request.getEmail());
        mail.setSubject(request.getTitle());
        mail.setText(request.getContent());
//        javaMailSender.send(mail);
    }
}
