package com.grupo7.tarea1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.grupo7.tarea1.models.Actor;

//CrudRespository<Nombre entidad, Tipo del ID>
//JPA Se encarga de analizar el metodo que uno crea!.

public interface ActorRepository extends CrudRepository<Actor,Integer>
{
    public Actor findActorByActorId(Integer id);
    public Iterable<Actor> findActorByFilmActorFilmFilmId(Integer filmId);

}
