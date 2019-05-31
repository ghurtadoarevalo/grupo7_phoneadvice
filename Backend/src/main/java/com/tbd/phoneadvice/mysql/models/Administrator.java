package com.tbd.phoneadvice.mysql.models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "administrator",schema = "phoneadvice")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "administrator_id", unique = true, nullable = false)
    private int administrator_id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String first_name;

    @Column(name = "last_name", nullable = false, length = 30)
    private String last_name;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Column(name = "assessment", nullable = false)
    private int assessment;

    public int getAssessment() {
        return assessment;
    }

    public int getAdministrator_id() {
        return administrator_id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public void setAdministrator_id(int administrator_id) {
        this.administrator_id = administrator_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

