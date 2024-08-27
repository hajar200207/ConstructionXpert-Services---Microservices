package com.constructionxpert.resourceservice.repository;

import com.constructionxpert.resourceservice.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByTaskId(Long taskId);
}
