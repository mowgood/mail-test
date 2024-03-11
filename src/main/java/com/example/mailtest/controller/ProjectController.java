package com.example.mailtest.controller;

import com.example.mailtest.dto.request.ProjectCreateRequest;
import com.example.mailtest.dto.response.ProjectCreateResponse;
import com.example.mailtest.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody ProjectCreateRequest request) {
        ProjectCreateResponse response = projectService.createProject(request);
        return ResponseEntity.created(URI.create("/projects/" + response.getSavedId())).build();
    }
}
