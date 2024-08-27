package com.constructionxpert.taskservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;
    @Column(name = "project_id")
    private Long projectId;
}
