package com.anhvv.hibernate.example.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Data
@Table(name = "student_subject_map")
@Entity
@IdClass(StudentSubjectMapEntity.StudentSubjectId.class)
public class StudentSubjectMapEntity {

    @Id
    private Long studentId;

    @Id
    private Long subjectId;

    private String name;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentSubjectId implements Serializable {

        private Long studentId;

        private Long subjectId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentSubjectId that = (StudentSubjectId) o;
            return Objects.equals(studentId, that.studentId) &&
                    Objects.equals(subjectId, that.subjectId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, subjectId);
        }

        public Long getStudentId() {
            return studentId;
        }

        public void setStudentId(Long studentId) {
            this.studentId = studentId;
        }

        public Long getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(Long subjectId) {
            this.subjectId = subjectId;
        }
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
