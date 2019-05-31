package com.grupo7.tarea1.services;

import com.grupo7.tarea1.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo7.tarea1.models.Actor;
import com.grupo7.tarea1.models.FilmActor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Crea un sinlgeton de este servicio, que hace llamado al controlador.
//Aca recae toda la logica de negocio, no en el controlador!

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public Iterable<Actor> getAllActors()
    {
        return actorRepository.findAll();
    }

    public Actor saveActor(Actor a)
    {
        return actorRepository.save(a);
    }

    public Actor getActor(Integer id)
    {
        return actorRepository.findActorByActorId(id);
    }

    public Iterable<Actor> getActorByFilm(Integer film_id)
    {
        return actorRepository.findActorByFilmActorFilmFilmId(film_id);
    }

    //
    public ArrayList<Actor> getActorByFilmA(Integer film_id)
    {
        Iterable<Actor> iterableActors = actorRepository.findAll();
        ArrayList<Actor> newList = new ArrayList<>();
        for(Actor a:iterableActors)
        {
            Set<FilmActor> listA = a.getFilmActor();
            int belong = 0;
            for(FilmActor fa:listA)
            {
                if(fa.getId().getFilmId() == film_id)
                {
                    belong = 1;
                    break;
                }
            }
            if(belong == 1)
            {
                newList.add(a);
            }
        }
        return newList;
    }

}
