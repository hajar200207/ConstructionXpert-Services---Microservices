package com.constructionxpert.resourceservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {
    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private Long projectId;
}

