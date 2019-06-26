package com.tbd.phoneadvice.mongo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import com.tbd.phoneadvice.neo4j.models.NodeBrand;
import com.tbd.phoneadvice.neo4j.models.NodePhone;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @SerializedName("screen_name")
    private String screenName;
    private String location;
    private String urlProfile;
    private String urlPhoto;
    private String email;
    private String description;
    private Date createdAt;

    @SerializedName("followers_count")
    private int followersCount;


    public User(Long id, String name, String screenName, String location, int followersCount) {
        this.id = id;
        this.name = name;
        this.screenName = screenName;
        this.location = location;
        this.followersCount = followersCount;
        this.urlProfile = "";
        this.urlPhoto = "";
        this.email = "";
        this.description = "";
        this.createdAt = null;
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

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
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


}