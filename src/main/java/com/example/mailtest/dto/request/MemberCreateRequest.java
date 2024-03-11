package com.example.mailtest.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberCreateRequest {

    private String name;

    private String email;

    @Builder
    public MemberCreateRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
