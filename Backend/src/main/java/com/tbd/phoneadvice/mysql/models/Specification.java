package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "specification",schema = "phoneadvice")
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specification_id", unique = true, nullable = false)
    private int specification_id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "assessment", nullable = false)
    private int assessment;

    @ManyToMany(mappedBy = "specifications")
    private Set<Phone> phones = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistic_id", referencedColumnName = "statistic_id")
    private Statistic statistic;

    @OneToMany(mappedBy = "specification", cascade = CascadeType.ALL)
    private Set<Word> words;

    public int getAssessment() {
        return assessment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }
}
