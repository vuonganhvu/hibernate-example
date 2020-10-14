package com.anhvv.hibernate.example.batch;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/hibernate-example/batch")
@AllArgsConstructor
@Log4j2
public class BatchController {

    private final SchoolRepository schoolRepository;

    @PostMapping("/insert")
    @Transactional
    public ResponseEntity createBatchSchool(){
        log.info("Begin insert: " + System.currentTimeMillis());
        List<SchoolEntity> schoolEntities = new ArrayList<>();
        for(int i =1; i < 1000; i++) {
            SchoolEntity schoolEntity = new SchoolEntity();
            schoolEntity.setId((long) i);
            schoolEntity.setName("Name " + i);
            schoolEntities.add(schoolEntity);
        }
        schoolRepository.saveAll(schoolEntities);
        log.info("End insert: " + System.currentTimeMillis());
        return ResponseEntity.ok("OK");
    }
}
