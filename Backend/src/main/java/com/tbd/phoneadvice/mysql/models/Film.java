package com.tbd.phoneadvice.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film",schema = "phoneadvice")
public class Film implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="film_id", unique=true, nullable=false)
    private Long filmId;

    @Column(name="title", nullable=false, length=45)
    private String title;

    @Column(name="year", nullable=false, length=45)
    private String year;

    @Column(name="genre", nullable=false)
    private String genre;

    @Column(name="last_update", nullable=false)
    private Timestamp lastUpdate;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors = new HashSet<>();

    public Film() {
    }

    public Set<Actor> getActors()
    {
        return actors;
    }


    public Long getFilmId() {
        return filmId;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setFilmId(Long FilmId) {
        this.filmId = FilmId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
