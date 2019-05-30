package com.tbd.phoneadvice.mysql.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "gamma",schema = "phoneadvice")
@Data
public class Gamma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gamma_id", unique = true, nullable = false)
    private Long gamma_id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "min_price", nullable = false)
    private int min_price;

    @Column(name = "max_price", nullable = false)
    private int max_price;

    @OneToMany(mappedBy = "gamma", cascade = CascadeType.ALL)
    private Set<Phone> phones;
}