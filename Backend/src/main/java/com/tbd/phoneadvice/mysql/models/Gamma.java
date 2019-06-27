package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long gammaId;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "min_price", nullable = false)
    private int min_price;

    @Column(name = "max_price", nullable = false)
    private int max_price;

    @JsonIgnore
    @OneToMany(mappedBy = "gamma", cascade = CascadeType.ALL)
    private Set<Phone> phones;

    public Long getGammaId() {
        return gammaId;
    }

    public void setGammaId(Long gammaId) {
        this.gammaId = gammaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMin_price() {
        return min_price;
    }

    public void setMin_price(int min_price) {
        this.min_price = min_price;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}