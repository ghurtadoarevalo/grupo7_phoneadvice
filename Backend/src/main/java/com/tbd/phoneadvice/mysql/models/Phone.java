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
    private Set<WordPhone> phoneWords;

    @JsonIgnore
    @OneToMany(mappedBy = "phone", cascade = CascadeType.ALL)
    private Set<PhoneSpecification> phoneSpecifications;

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }
}
