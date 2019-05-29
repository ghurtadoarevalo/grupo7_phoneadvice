package com.tbd.phoneadvice.mysql.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "phone_specification",schema = "phoneadvice")
public class PhoneSpecification {

    @EmbeddedId
    private PhoneSpecificationKey phone_specification_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("phone_id")
    @JoinColumn(name = "phone_id")
    private Phone phone;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("specification_id")
    @JoinColumn(name = "specification_id")
    private Specification specification;

    @Column(name = "assessment", nullable = false)
    private int assessment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistic_id", referencedColumnName = "statistic_id")
    private Statistic statistic;

}


