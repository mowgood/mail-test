package com.example.mailtest.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MailSendRequest {

    private String email;

    private String name;

    private String title;

    private String content;

    @Builder
    public MailSendRequest(String email, String name, String title, String content) {
        this.email = email;
        this.name = name;
        this.title = title;
        this.content = content;
    }
}
