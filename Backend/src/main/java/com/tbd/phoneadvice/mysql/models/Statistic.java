package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "statistic",schema = "phoneadvice")
@Data
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statistic_id", unique = true, nullable = false)
    private Long statisticId;

    @Column(name = "positive_density", nullable = false)
    private int positive_density;

    @Column(name = "neutral_density", nullable = false)
    private int neutral_density;

    @Column(name = "negative_density", nullable = false)
    private int negative_density;

    @JsonIgnore
    @OneToMany(mappedBy = "statistic", cascade = CascadeType.ALL)
    private Set<Phone> phones;

    @JsonIgnore
    @OneToMany(mappedBy = "statistic", cascade = CascadeType.ALL)
    private Set<PhoneSpecification> phoneSpecifications;

    @JsonIgnore
    @OneToMany(mappedBy = "statistic", cascade = CascadeType.ALL)
    private Set<Brand> brands;

    public Long getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(Long statisticId) {
        this.statisticId = statisticId;
    }

    public int getNegative_density() {
        return negative_density;
    }

    public int getNeutral_density() {
        return neutral_density;
    }

    public int getPositive_density() {
        return positive_density;
    }

    public void setNegative_density(int negative_density) {
        this.negative_density = negative_density;
    }

    public void setNeutral_density(int neutral_density) {
        this.neutral_density = neutral_density;
    }

    public void setPositive_density(int positive_density) {
        this.positive_density = positive_density;
    }
}
