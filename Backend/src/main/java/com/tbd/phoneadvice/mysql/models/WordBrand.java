package com.tbd.phoneadvice.mysql.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "word_brand",schema = "phoneadvice")
@Data
public class WordBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_brand_id", unique = true, nullable = false)
    private Long word_brand_id;

    @Column(name = "content", nullable = false, length = 30)
    private String content;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;


    public Long getWord_brand_id() {
        return word_brand_id;
    }

    public void setWord_brand_id(Long word_brand_id) {
        this.word_brand_id = word_brand_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
