package com.anhvv.hibernate.example.composite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    @Query("select s, ss, s.name from  SubjectEntity s left join StudentSubjectMapEntity ss on s.id = ss.subjectId")
    List<Object[]> getComposite();
}
