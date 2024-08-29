package com.constructionxpert.resourceservice.client;

import com.constructionxpert.resourceservice.dto.TaskDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "task-service")
public interface TaskClient {

    @GetMapping("/tasks/{id}")
    TaskDto getTaskById(@PathVariable("id") Long id);
}
