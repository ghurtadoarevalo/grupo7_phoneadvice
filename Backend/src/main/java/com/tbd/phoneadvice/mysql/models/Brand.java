package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long brandId;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "assessment", nullable = false)
    private int assessment;

    @Column(name = "image", nullable = false, length = 500)
    private String image;

    @JsonIgnore
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Phone> phones;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistic_id", referencedColumnName = "statistic_id")
    private Statistic statistic;

    @JsonIgnore
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<WordBrand> brandWords;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }
}
