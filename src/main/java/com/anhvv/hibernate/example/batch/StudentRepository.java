package com.anhvv.hibernate.example.batch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query("update StudentEntity s set s.name = :name where s.id = :id ")
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    void updateStudent(Long id, String name);
}
