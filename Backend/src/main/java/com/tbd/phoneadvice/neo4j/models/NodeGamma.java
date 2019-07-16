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
public class NodeGamma {
    @Id
    @GeneratedValue
    private Long id;
    //Nombre
    private String gammaName;
    private Long gammaID;

    private Double size;

    @JsonIgnore
    @Relationship(type = "RELATED",direction = Relationship.OUTGOING)
    private List<NodePhone> phones = new ArrayList<>();

    public NodeGamma(String gammaName, Long gammaID) {
        this.gammaName = gammaName;
        this.gammaID = gammaID;
        this.size = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGammaName() {
        return gammaName;
    }

    public void setGammaName(String gammaName) {
        this.gammaName = gammaName;
    }

    public Long getGammaID() {
        return gammaID;
    }

    public void setGammaID(Long gammaID) {
        this.gammaID = gammaID;
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
}
