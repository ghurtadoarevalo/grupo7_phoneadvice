package com.tbd.phoneadvice.mysql.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class PhoneSpecificationKey implements Serializable {

    @Column(name = "phone_id", unique = true, nullable = false)
    private Long phoneId;

    @Column(name = "specification_id", unique = true, nullable = false)
    private Long specificationId;
}
