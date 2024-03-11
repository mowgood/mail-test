package com.example.mailtest.event;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ProjectCreateEvent {

    private final List<String> emailList;

    private final String projectTitle;

    @Builder
    public ProjectCreateEvent(List<String> emailList, String projectTitle) {
        this.emailList = emailList;
        this.projectTitle = projectTitle;
    }
}
