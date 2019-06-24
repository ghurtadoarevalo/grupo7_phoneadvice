package com.tbd.phoneadvice.neo4j.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class NodeUser {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int followersCount;
    private Long userID;

    private Double size;

    @JsonIgnore
    @Relationship(type = "TWEET_ABOUT",direction = Relationship.OUTGOING)
    private List<NodePhone> phones = new ArrayList<>();

    @JsonIgnore
    @Relationship(type = "TWEET_ABOUT",direction = Relationship.OUTGOING)
    private List<NodeBrand> brands = new ArrayList<>();

    public NodeUser(String name, int followersCount,Long userID)
    {
        this.name = name;
        this.followersCount = followersCount;
        this.userID = userID;
        this.size = 0.0;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public List<NodePhone> getPhones() {
        return phones;
    }

    public void setPhones(List<NodePhone> phones) {
        this.phones = phones;
    }

    public List<NodeBrand> getBrands() {
        return brands;
    }

    public void setBrands(List<NodeBrand> brands) {
        this.brands = brands;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}