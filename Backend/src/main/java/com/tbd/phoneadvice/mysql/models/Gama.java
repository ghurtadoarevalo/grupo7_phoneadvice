package com.tbd.phoneadvice.mysql.models;

import javax.persistence.*;


@Entity
@Table(name = "gama",schema = "phoneadvice")
public class Gama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gama_id", unique = true, nullable = false)
    private int gama_id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "min_price", nullable = false)
    private int min_price;

    @Column(name = "max_price", nullable = false)
    private int max_price;

    public String getName() {
        return name;
    }

    public int getGama_id() {
        return gama_id;
    }

    public int getMax_price() {
        return max_price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGama_id(int gama_id) {
        this.gama_id = gama_id;
    }

    public void setMax_price(int max_price) {
        this.max_price = max_price;
    }

    public void setMin_price(int min_price) {
        this.min_price = min_price;
    }
}