package com.grupo7.tarea1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.grupo7.tarea1.models.Film;
import com.grupo7.tarea1.models.Actor;

public interface FilmRepository extends CrudRepository<Film,Integer>
{
    public Film findFilmByFilmId(Integer Id);

    public Iterable<Film> findFilmByFilmActorIdActorId(Integer actorId);

}
