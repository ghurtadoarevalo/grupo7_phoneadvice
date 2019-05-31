package com.tbd.phoneadvice.mysql.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PhoneSpecificationKey implements Serializable {

    @Column(name = "phone_id", unique = true, nullable = false)
    private int phone_id;

    @Column(name = "specification_id", unique = true, nullable = false)
    private int specification_id;
}
