package com.example.mailtest.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ProjectCreateRequest {

    private String title;

    private String content;

    private List<Long> memberIdList;

    @Builder
    public ProjectCreateRequest(String title, String content, List<Long> memberIdList) {
        this.title = title;
        this.content = content;
        this.memberIdList = memberIdList;
    }
}
