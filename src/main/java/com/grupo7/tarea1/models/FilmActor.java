package com.grupo7.tarea1.models;


import javax.persistence.*;

@Entity
public class FilmActor {


    @EmbeddedId
    FilmActorKey id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    Film film;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    Actor actor;

    public FilmActorKey getId() {
        return id;
    }

    public void setId(FilmActorKey id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }



    //Valores intermedios.


}
