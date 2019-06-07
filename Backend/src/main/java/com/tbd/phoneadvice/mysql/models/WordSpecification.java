package com.tbd.phoneadvice.mysql.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "word_specification",schema = "phoneadvice")
@Data
public class WordSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_specification_id", unique = true, nullable = false)
    private Long word_specification_id;

    @Column(name = "content", nullable = false, length = 30)
    private String content;

    /*
    //No se si sera necesario
    @Column(name = "type", nullable = false, length = 30)
    private String type;


     */
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specification_id", referencedColumnName = "specification_id")
    private Specification specification;


    public Long getWord_specification_id() {
        return word_specification_id;
    }

    public void setWord_specification_id(Long word_specification_id) {
        this.word_specification_id = word_specification_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }
}
