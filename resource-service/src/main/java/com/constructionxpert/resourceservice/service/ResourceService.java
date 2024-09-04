package com.constructionxpert.resourceservice.service;

import com.constructionxpert.resourceservice.client.TaskClient;
import com.constructionxpert.resourceservice.dto.TaskDto;
import com.constructionxpert.resourceservice.entity.Resource;
import com.constructionxpert.resourceservice.repository.ResourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final TaskClient taskClient;

    public ResourceService(ResourceRepository resourceRepository, TaskClient taskClient) {
        this.resourceRepository = resourceRepository;
        this.taskClient = taskClient;
    }

    public Resource createResource(Resource resource) {
        // Check if the task exists
        TaskDto taskDto = taskClient.getTaskById(resource.getTaskId());
        if (taskDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }

        return resourceRepository.save(resource);
    }

    public List<Resource> getResourcesByTaskId(Long taskId) {
        return resourceRepository.findByTaskId(taskId);
    }

    public Resource updateResource(Long id, Resource resourceDetails) {
        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        resource.setName(resourceDetails.getName());
        resource.setType(resourceDetails.getType());
        resource.setQuantity(resourceDetails.getQuantity());
        return resourceRepository.save(resource);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }
}
