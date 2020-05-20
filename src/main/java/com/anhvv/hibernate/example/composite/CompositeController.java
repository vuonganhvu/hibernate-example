package com.anhvv.hibernate.example.composite;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hibernate-example/composite/")
@AllArgsConstructor
@Transactional
public class CompositeController {

    private final SubjectRepository subjectRepository;

    @GetMapping("/test")
    public ResponseEntity getComposite(){
        List<Object[]> rest = subjectRepository.getComposite();
        return ResponseEntity.ok(rest);
    }
}
