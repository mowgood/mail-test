package com.example.mailtest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @NotNull
    @Column(unique = true)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Builder
    public Project(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
