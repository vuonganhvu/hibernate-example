package com.anhvv.hibernate.example.inheritance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query("select t from TASK t where t.task.id in (select td from TaskEntity td where td.id in (7,8,9))")
    List<TaskEntity> testQuery();
}
