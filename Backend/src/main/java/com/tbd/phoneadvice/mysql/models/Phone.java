package com.tbd.phoneadvice.mysql.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "phone",schema = "phoneadvice")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id", unique = true, nullable = false)
    private int phone_id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "model", nullable = false, length = 30)
    private String model;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "assessment", nullable = false)
    private int assessment;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "phone_specification",
            joinColumns = @JoinColumn(name = "phone_id"),
            inverseJoinColumns = @JoinColumn(name = "specification_id"))
    private Set<Specification> specifications = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "data_sheet_id", referencedColumnName = "data_sheet_id")
    private DataSheet data_sheet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gamma_id", referencedColumnName = "gamma_id")
    private Gamma gamma;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistic_id", referencedColumnName = "statistic_id")
    private Statistic statistic;

    @OneToMany(mappedBy = "phone", cascade = CascadeType.ALL)
    private Set<Word> words;

    public void setName(String name) {
        this.name = name;
    }

    public void setAssesstment(int assessment) {
        this.assessment = assessment;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public String getName() {
        return name;
    }

    public int getPhone_id() {
        return phone_id;
    }

    public int getAssessment() {
        return assessment;
    }

    public String getDescription() {
        return description;
    }

    public String getModel() {
        return model;
    }

}
