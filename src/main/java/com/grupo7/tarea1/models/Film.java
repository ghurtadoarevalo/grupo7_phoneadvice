package com.grupo7.tarea1.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
//import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
//@Table(name="film")
//@NamedQuery(name="film.findAll", query="SELECT a FROM Film a") implements Serializable
public class Film
{
    //private static final long serialVersionUID = 1L;

    @Id
    @Column(name="film_id", unique=true, nullable=false)
    private int filmId;

    @Column(name="title", nullable=false, length=20)
    private String title;

    @Column(name="description", nullable=false, length=50)
    private String description;

    @Column(name="release_year", nullable=false, length=50)
    private int release_year;

    @Column(name="last_update", nullable=false)
    private Timestamp lastUpdate;

    @JsonIgnore
    @OneToMany(mappedBy = "film")
    private Set<FilmActor> filmActor;


    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int id) {
        this.filmId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
