package com.anhvv.hibernate.example.update;

import com.anhvv.hibernate.example.batch.SchoolEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hibernate-example/update")
@AllArgsConstructor
public class UpdateController {
    private final IUpdateService updateService;

    @PutMapping("/not-find-entity/{id}")
    public ResponseEntity updateNotFindEntity(@PathVariable("id") Long id, @RequestBody SchoolUpdateReq schoolReq) {
        updateService.updateNotFindId(id, schoolReq);
        return ResponseEntity.ok("OK");
    }

    @PutMapping("/find-entity/{id}")
    public ResponseEntity updateFindEntity(@PathVariable("id") Long id, @RequestBody SchoolUpdateReq schoolReq) {
        updateService.updateFindId(id, schoolReq);
        return ResponseEntity.ok("OK");
    }
}
