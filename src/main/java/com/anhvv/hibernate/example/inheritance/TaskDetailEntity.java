package com.anhvv.hibernate.example.inheritance;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "TASK")
@Data
@Where(clause = "type = 'TASK'")
public class TaskDetailEntity extends ActionDetailEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_id")
    private TaskEntity task;
}
