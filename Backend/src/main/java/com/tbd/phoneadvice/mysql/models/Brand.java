package com.tbd.phoneadvice.mysql.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "brand",schema = "phoneadvice")
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", unique = true, nullable = false)
    private Long brand_id;

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

    public Brand(String name, String description, int assessment) {
        this.name = name;
        this.description = description;
        this.assessment = assessment;
    }
}
