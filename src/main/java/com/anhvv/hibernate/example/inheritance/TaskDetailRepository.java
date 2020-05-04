package com.anhvv.hibernate.example.inheritance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDetailRepository extends JpaRepository<TaskDetailEntity, Long> {
}
