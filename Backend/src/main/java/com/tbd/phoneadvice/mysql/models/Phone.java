package com.tbd.phoneadvice.mysql.models;

import javax.persistence.*;

@Entity
@Table(name = "phone",schema = "phoneadvice")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id", unique = true, nullable = false)
    private int phone_id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "model", nullable = false, length = 30)
    private String model;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "assesstment", nullable = false)
    private int assesstment;

    public void setName(String name) {
        this.name = name;
    }

    public void setAssesstment(int assesstment) {
        this.assesstment = assesstment;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public String getName() {
        return name;
    }

    public int getPhone_id() {
        return phone_id;
    }

    public int getAssesstment() {
        return assesstment;
    }

    public String getDescription() {
        return description;
    }

    public String getModel() {
        return model;
    }

}
