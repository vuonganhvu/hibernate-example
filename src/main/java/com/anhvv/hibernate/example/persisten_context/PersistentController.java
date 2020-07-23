package com.anhvv.hibernate.example.persisten_context;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/hibernate-example/persistent")
public class PersistentController {

    private final PersistentService persistentService;

    @PostMapping("/test")
    @Transactional
    public ResponseEntity createBatchSchool() {
        persistentService.testPersistentFlushAutomatically();
        return ResponseEntity.ok("OK");
    }
}
