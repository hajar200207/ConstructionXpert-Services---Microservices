package com.constructionxpert.taskservice.service;

import com.constructionxpert.taskservice.client.ProjectClient;
import com.constructionxpert.taskservice.dto.ProjectDto;
import com.constructionxpert.taskservice.dto.TaskDto;
import com.constructionxpert.taskservice.entity.Task;
import com.constructionxpert.taskservice.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectClient projectClient;

    public TaskService(TaskRepository taskRepository, ProjectClient projectClient) {
        this.taskRepository = taskRepository;
        this.projectClient = projectClient;
    }

    public TaskDto createTask(TaskDto taskDto) {
        ProjectDto project = projectClient.getProjectById(taskDto.getProjectId());
        if (project == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projet non trouvé");
        }

        Task task = mapToEntity(taskDto);
        Task savedTask = taskRepository.save(task);
        return mapToDto(savedTask);
    }

    public List<TaskDto> getTasksByProjectId(Long projectId) {
        return taskRepository.findByProjectId(projectId)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public TaskDto updateTask(Long id, TaskDto taskDto) {
        if (!taskRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tâche non trouvée");
        }
        ProjectDto project = projectClient.getProjectById(taskDto.getProjectId());
        if (project == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projet non trouvé");
        }

        Task task = mapToEntity(taskDto);
        task.setId(id);
        Task updatedTask = taskRepository.save(task);
        return mapToDto(updatedTask);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tâche non trouvée");
        }
        taskRepository.deleteById(id);
    }

    private TaskDto mapToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setStartDate(task.getStartDate());
        taskDto.setEndDate(task.getEndDate());
        taskDto.setStatus(task.getStatus());
        taskDto.setProjectId(task.getProjectId());
        return taskDto;
    }

    private Task mapToEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setStartDate(taskDto.getStartDate());
        task.setEndDate(taskDto.getEndDate());
        task.setStatus(taskDto.getStatus());
        task.setProjectId(taskDto.getProjectId());
        return task;
    }
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tâche non trouvée"));
        return mapToDto(task);
    }
}
