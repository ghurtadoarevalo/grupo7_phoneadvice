package com.tbd.phoneadvice.mysql.models;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "gamma",schema = "phoneadvice")
public class Gamma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gamma_id", unique = true, nullable = false)
    private int gamma_id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "min_price", nullable = false)
    private int min_price;

    @Column(name = "max_price", nullable = false)
    private int max_price;

    @OneToMany(mappedBy = "gamma", cascade = CascadeType.ALL)
    private Set<Phone> phones;

    public String getName() {
        return name;
    }

    public int getMin_price() {
        return min_price;
    }

    public int getGamma_id() {
        return gamma_id;
    }

    public int getMax_price() {
        return max_price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGamma_id(int gamma_id) {
        this.gamma_id = gamma_id;
    }

    public void setMax_price(int max_price) {
        this.max_price = max_price;
    }

    public void setMin_price(int min_price) {
        this.min_price = min_price;
    }
}