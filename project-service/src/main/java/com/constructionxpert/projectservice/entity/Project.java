package com.constructionxpert.projectservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double budget;
}
