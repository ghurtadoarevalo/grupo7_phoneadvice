package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "phone_specification",schema = "phoneadvice")
@Data
public class PhoneSpecification {

    @EmbeddedId
    private PhoneSpecificationKey psId;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("phoneId")
    @JoinColumn(name = "phone_id")
    private Phone phone;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("specificationId")
    @JoinColumn(name = "specification_id")
    private Specification specification;

    @Column(name = "assessment", nullable = false)
    private int assessment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistic_id", referencedColumnName = "statistic_id")
    private Statistic statistic;

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
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


