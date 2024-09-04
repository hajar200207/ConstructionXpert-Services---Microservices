package com.constructionxpert.projectservice.service;

import com.constructionxpert.projectservice.entity.Project;
import com.constructionxpert.projectservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
    }

    public Project updateProject(Long id, Project project) {
        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Project not found with id " + id);
        }
        project.setId(id);
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Project not found with id " + id);
        }
        projectRepository.deleteById(id);
    }
}
