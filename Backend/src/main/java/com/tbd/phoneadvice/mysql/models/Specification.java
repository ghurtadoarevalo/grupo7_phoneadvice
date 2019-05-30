package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "specification",schema = "phoneadvice")
@Data
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specification_id", unique = true, nullable = false)
    private Long specification_id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @OneToMany(mappedBy = "specification", cascade = CascadeType.ALL)
    private Set<Word> words;

    @OneToMany(mappedBy = "specification")
    Set<PhoneSpecification> phoneSpecifications;
}
