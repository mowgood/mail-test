package com.example.mailtest.service;

import com.example.mailtest.dto.request.MailSendRequest;

public interface MailService {

    void sendMailAsync(MailSendRequest request);

    void sendMailSync(MailSendRequest request);
}
