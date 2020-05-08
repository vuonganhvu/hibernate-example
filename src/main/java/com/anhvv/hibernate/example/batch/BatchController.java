package com.anhvv.hibernate.example.batch;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/hibernate-example/batch")
@AllArgsConstructor
public class BatchController {

    private final SchoolRepository schoolRepository;

    @PostMapping("/school")
    public ResponseEntity createBatchSchool(){
        List<SchoolEntity> schoolEntities = new ArrayList<>();
        for(int i =0; i < 10; i++) {
            SchoolEntity schoolEntity = new SchoolEntity();
            schoolEntity.setName("Name " + i);
            schoolEntities.add(schoolEntity);
        }
        schoolRepository.saveAll(schoolEntities);
        return ResponseEntity.ok("OK");
    }
}
