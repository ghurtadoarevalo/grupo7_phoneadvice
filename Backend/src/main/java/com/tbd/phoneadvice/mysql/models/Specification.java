package com.tbd.phoneadvice.mysql.models;

import javax.persistence.*;


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
