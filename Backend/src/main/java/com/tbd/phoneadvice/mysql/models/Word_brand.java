package com.tbd.phoneadvice.mysql.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "word_brand",schema = "phoneadvice")
@Data
public class Word_brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_brand_id", unique = true, nullable = false)
    private Long word_brand_id;

    @Column(name = "content", nullable = false, length = 30)
    private String content;

    //No se si sera necesario
    @Column(name = "type", nullable = false, length = 30)
    private String type;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;
}
