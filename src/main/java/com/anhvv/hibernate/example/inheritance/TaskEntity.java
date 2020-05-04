package com.anhvv.hibernate.example.inheritance;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "task")
@Data
public class TaskEntity {

    @Id
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "task")
    private List<TaskDetailEntity> taskDetails;
}
