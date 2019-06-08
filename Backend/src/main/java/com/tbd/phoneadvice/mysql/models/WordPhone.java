package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "word_phone",schema = "phoneadvice")
@Data
public class WordPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_phone_id", unique = true, nullable = false)
    private Long word_phone_id;

    @Column(name = "content", nullable = false, length = 30)
    private String content;

    /*
    //No se si sera necesario
    @Column(name = "type", nullable = false, length = 30)
    private String type;

     */

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", referencedColumnName = "phone_id")
    private Phone phone;

    /*
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specification_id", referencedColumnName = "specification_id")
    private Specification specification;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;

     */

    public Long getWord_phone_id() {
        return word_phone_id;
    }

    public void setWord_phone_id(Long word_phone_id) {
        this.word_phone_id = word_phone_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
