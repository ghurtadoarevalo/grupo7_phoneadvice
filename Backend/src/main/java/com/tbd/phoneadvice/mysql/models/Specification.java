package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "specification",schema = "phoneadvice")
@Data
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specification_id", unique = true, nullable = false)
    private Long specificationId;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "specification", cascade = CascadeType.ALL)
    private Set<WordSpecification> words_specifications;

    @JsonIgnore
    @OneToMany(mappedBy = "specification")
    Set<PhoneSpecification> phoneSpecifications;


    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
