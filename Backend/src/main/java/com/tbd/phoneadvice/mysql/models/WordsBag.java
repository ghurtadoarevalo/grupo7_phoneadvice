package com.tbd.phoneadvice.mysql.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "words_bag",schema = "phoneadvice")
@Data
public class WordsBag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "words_bag_id", unique = true, nullable = false)
    private Long words_bag_id;

    @Column(name = "type", nullable = false, length = 30)
    private String type;

    @OneToMany(mappedBy = "words_bag", cascade = CascadeType.ALL)
    private Set<Word> words;
}