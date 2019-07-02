package com.tbd.phoneadvice.neo4j.models;

import com.tbd.phoneadvice.mysql.models.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodePhone {
    @Id
    @GeneratedValue
    private Long id;

    private String model;
    private Long phoneID;

    private Double size;

    public Phone getPhoneSQL() {
        return phoneSQL;
    }

    public void setPhoneSQL(Phone phoneSQL) {
        this.phoneSQL = phoneSQL;
    }

    private Phone phoneSQL;

    public NodePhone(String model, Long phoneID) {
        this.model = model;
        this.phoneID = phoneID;
        this.size = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(Long phoneID) {
        this.phoneID = phoneID;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
