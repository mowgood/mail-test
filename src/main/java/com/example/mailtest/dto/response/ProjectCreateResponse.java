package com.example.mailtest.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProjectCreateResponse {

    private Long savedId;

    @Builder
    public ProjectCreateResponse(Long savedId) {
        this.savedId = savedId;
    }
}
