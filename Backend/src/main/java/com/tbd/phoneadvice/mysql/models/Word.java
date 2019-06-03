package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "word",schema = "phoneadvice")
@Data
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id", unique = true, nullable = false)
    private Long specification_id;

    @Column(name = "content", nullable = false, length = 30)
    private String content;

    @Column(name = "type", nullable = false, length = 30)
    private String type;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", referencedColumnName = "phone_id")
    private Phone phone;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specification_id", referencedColumnName = "specification_id")
    private Specification specification;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;

}
