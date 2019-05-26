package com.tbd.phoneadvice.mysql.models;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "brand",schema = "phoneadvice")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", unique = true, nullable = false)
    private int brand_id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "assessment", nullable = false)
    private int assessment;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Phone> phones;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistic_id", referencedColumnName = "statistic_id")
    private Statistic statistic;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Word> words;


    public void setDescription(String description) {
        this.description = description;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getAssessment() {
        return assessment;
    }

    public int getBrand_id() {
        return brand_id;
    }
}
