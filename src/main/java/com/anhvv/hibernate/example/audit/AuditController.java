package com.anhvv.hibernate.example.audit;

import com.anhvv.hibernate.example.batch.StudentEntity;
import com.anhvv.hibernate.example.batch.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hibernate-example/audit")
@AllArgsConstructor
@Transactional
public class AuditController {

    private final StudentRepository studentRepository;

    @DeleteMapping("/student/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.ok("OK");
    }

    @PutMapping("/student/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id, @RequestBody StudentEntity student) {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        studentEntity.setName(student.getName());
        studentRepository.save(studentEntity);
        return ResponseEntity.ok("OK");
    }
}
