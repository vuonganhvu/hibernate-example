package com.anhvv.hibernate.example.batch;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Data
@Table(name = "school")
@Entity
public class SchoolEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Version
    private Long version;
}
