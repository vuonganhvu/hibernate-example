package com.anhvv.hibernate.example.batch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {

    @Query("select s.id, concat(st.id, 'v')  from SchoolEntity s, StudentEntity st group by s.id")
    List<Object[]> abc();
}
