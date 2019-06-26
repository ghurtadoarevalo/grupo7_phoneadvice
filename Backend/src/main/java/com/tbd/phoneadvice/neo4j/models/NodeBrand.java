package com.tbd.phoneadvice.neo4j.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tbd.phoneadvice.mongo.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeBrand {
    @Id
    @GeneratedValue
    private Long id;

    private String brandName;
    private Long brandID;

    private Double size;

    @Relationship(type = "HAS",direction = Relationship.OUTGOING)
    private List<NodePhone> phones = new ArrayList<>();

    private List<User> users = new ArrayList<>();

    public NodeBrand(String brandName, Long brandID) {
        this.brandName = brandName;
        this.brandID = brandID;
        this.size = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getBrandID() {
        return brandID;
    }

    public void setBrandID(Long brandID) {
        this.brandID = brandID;
    }

    public List<NodePhone> getPhones() {
        return phones;
    }

    public void setPhones(List<NodePhone> phones) {
        this.phones = phones;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

