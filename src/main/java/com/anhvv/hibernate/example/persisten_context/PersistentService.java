package com.anhvv.hibernate.example.persisten_context;

import com.anhvv.hibernate.example.batch.SchoolEntity;
import com.anhvv.hibernate.example.batch.SchoolRepository;
import com.anhvv.hibernate.example.batch.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PersistentService {
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;

    @Transactional
    public void testPersistentFlushAutomatically() {
        SchoolEntity schoolEntity = schoolRepository.findById(1L).get();
        schoolEntity.setName("Persistent Auto ClearAutomatically...");
        schoolRepository.save(schoolEntity);

        studentRepository.updateStudent(1L, "Anhvv");
        throw new RuntimeException("");

    }
}
