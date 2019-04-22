package com.grupo7.tarea1.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
//import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

//Le digo al JPA que esta es una entidad propia de la BD SQL
@Entity
//@Table(name="actor")
//@NamedQuery(name="Actor.findAll", query="SELECT a FROM Actor a") implements Serializable
public class Actor{
    //private static final long serialVersionUID = 1L;

    @Id
    @Column(name="actor_id", unique=true, nullable=false)
    private int actorId;

    @Column(name="first_name", nullable=false, length=45)
    private String firstName;

    @Column(name="last_name", nullable=false, length=45)
    private String lastName;

    @Column(name="last_update", nullable=false)
    private Timestamp lastUpdate;

    //Relacion

    @JsonIgnore
    @OneToMany(mappedBy = "actor")
    private Set<FilmActor> filmActor;

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<FilmActor> getFilmActor() {
        return filmActor;
    }

    public void setFilmActor(Set<FilmActor> filmActor) {
        this.filmActor = filmActor;
    }
}


