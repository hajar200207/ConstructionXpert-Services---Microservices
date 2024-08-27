package com.constructionxpert.projectservice.repository;

import com.constructionxpert.projectservice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
