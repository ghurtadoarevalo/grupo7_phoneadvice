package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "phone",schema = "phoneadvice")
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id", unique = true, nullable = false)
    private Long phoneId;

    @Column(name = "model", nullable = false, length = 30)
    private String model;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "image", nullable = false, length = 500)
    private String image;

    @Column(name = "assessment", nullable = false)
    private int assessment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "data_sheet_id", referencedColumnName = "data_sheet_id")
    private DataSheet data_sheet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gamma_id", referencedColumnName = "gamma_id")
    private Gamma gamma;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistic_id", referencedColumnName = "statistic_id")
    private Statistic statistic;

    @JsonIgnore
    @OneToMany(mappedBy = "phone", cascade = CascadeType.ALL)
    private Set<Word_phone> words_phones;

    @JsonIgnore
    @OneToMany(mappedBy = "phone", cascade = CascadeType.ALL)
    private Set<PhoneSpecification> phoneSpecifications;
}
