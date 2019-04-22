package com.grupo7.tarea1.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


//Logica tras reemplazo de Override y hash
//https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/composite-primary-key.html

@Embeddable
public class FilmActorKey implements Serializable {

    @Column(name = "film_id",nullable = true)
    Integer filmId;

    @Column(name = "actor_id",nullable = true)
    Integer actorId;

 

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object)
        {
            return true;
        }
        if (object == null || getClass() != object.getClass())
        {
            return false;
        }

        FilmActorKey Key1 = (FilmActorKey) object;

        if (this.filmId != Key1.filmId)
        {
            return false;
        }
        else
        {
            return actorId == Key1.actorId;
        }

      }


      @Override
      public int hashCode() {
          return Objects.hash(filmId, actorId);
      }

}
