package com.tbd.phoneadvice.mysql.models;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "words_bag",schema = "phoneadvice")
public class WordsBag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "words_bag_id", unique = true, nullable = false)
    private int words_bag_id;

    @Column(name = "type", nullable = false, length = 30)
    private String type;

    @OneToMany(mappedBy = "words_bag", cascade = CascadeType.ALL)
    private Set<Word> words;

    public int getWords_bag_id() {
        return words_bag_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWords_bag_id(int words_bag_id) {
        this.words_bag_id = words_bag_id;
    }
}