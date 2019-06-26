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
import java.util.Date;
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

    private String location;
    private String urlProfile;
    private String urlPhoto;
    private String email;
    private String description;
    private Date createdAt;


    @Relationship(type = "TWEET_ABOUT",direction = Relationship.OUTGOING)
    private List<NodePhone> phones = new ArrayList<>();

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrlProfile() {
        return urlProfile;
    }

    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setFromUser(User user) {
        this.name = user.getName();
        this.followersCount = user.getFollowersCount();
        this.userID = user.getId();
        this.location = user.getLocation();
        this.urlProfile = user.getUrlProfile();
        this.urlPhoto = user.getUrlPhoto();
        this.email = user.getEmail();
        this.description = user.getDescription();
        this.createdAt = user.getCreatedAt();
    }

}