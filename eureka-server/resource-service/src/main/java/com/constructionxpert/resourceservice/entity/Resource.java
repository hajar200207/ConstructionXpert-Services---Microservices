package com.constructionxpert.resourceservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resources")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private int quantity;
    @Column(name = "task_id")
    private Long taskId;
}
