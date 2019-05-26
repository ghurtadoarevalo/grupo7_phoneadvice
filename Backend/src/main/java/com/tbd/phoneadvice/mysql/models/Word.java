package com.tbd.phoneadvice.mysql.models;

import javax.persistence.*;


@Entity
@Table(name = "word",schema = "phoneadvice")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id", unique = true, nullable = false)
    private int specification_id;

    @Column(name = "content", nullable = false, length = 30)
    private String content;

    public int getSpecification_id() {
        return specification_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setSpecification_id(int specification_id) {
        this.specification_id = specification_id;
    }
}
