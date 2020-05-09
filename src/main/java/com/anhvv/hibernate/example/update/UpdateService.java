package com.anhvv.hibernate.example.update;

import com.anhvv.hibernate.example.batch.SchoolEntity;
import com.anhvv.hibernate.example.batch.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UpdateService implements IUpdateService {

    private final SchoolRepository schoolRepository;

    @Override
    public void updateNotFindId(Long id, SchoolUpdateReq schoolUpdateReq) {
        SchoolEntity schoolEntity = new SchoolEntity();
        schoolEntity.setId(id);
        schoolEntity.setName(schoolUpdateReq.getName());
        schoolRepository.save(schoolEntity);
    }

    @Override
    public void updateFindId(Long id, SchoolUpdateReq schoolUpdateReq) {
        Optional<SchoolEntity> oSchoolEntity = schoolRepository.findById(id);
        SchoolEntity schoolEntity = oSchoolEntity.orElseThrow(() -> new RuntimeException("school not find by id = " + id));
        schoolEntity.setName(schoolUpdateReq.getName());
        schoolRepository.save(schoolEntity);
    }
}
