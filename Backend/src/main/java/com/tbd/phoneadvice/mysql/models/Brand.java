package com.tbd.phoneadvice.mysql.models;

import javax.persistence.*;


@Entity
@Table(name = "brand",schema = "phoneadvice")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", unique = true, nullable = false)
    private int brand_id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "assesstment", nullable = false)
    private int assesstment;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAssesstment(int assesstment) {
        this.assesstment = assesstment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getAssesstment() {
        return assesstment;
    }

    public int getBrand_id() {
        return brand_id;
    }
}
