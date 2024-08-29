package com.constructionxpert.taskservice.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.constructionxpert.taskservice.dto.ProjectDto;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "project-service")
public interface ProjectClient {

    @GetMapping("/api/projects/{id}")
    ProjectDto getProjectById(@PathVariable("id") Long id);
}
