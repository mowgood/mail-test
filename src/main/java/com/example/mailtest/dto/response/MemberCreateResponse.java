package com.example.mailtest.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberCreateResponse {

    private Long savedId;

    @Builder
    public MemberCreateResponse(Long savedId) {
        this.savedId = savedId;
    }
}
