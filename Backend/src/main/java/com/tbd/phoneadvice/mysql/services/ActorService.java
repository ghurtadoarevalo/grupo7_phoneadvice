package com.tbd.phoneadvice.mysql.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.tbd.phoneadvice.mysql.models.Actor;
import com.tbd.phoneadvice.mysql.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import com.tbd.phoneadvice.mysql.repositories.ActorRepository;
import com.tbd.phoneadvice.mysql.repositories.FilmRepository;

import java.util.List;


@RestController
@RequestMapping(value = "/actor")
public class ActorService {

    @Autowired
    private ActorRepository repository;
    @Autowired
    private FilmRepository repository2;

    @RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
    @ResponseBody
    public List<Actor> getActorsByMovies(@PathVariable Long id)
    {
        System.out.println("holaaa");
        return this.repository.findActorsByFilms(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Actor> getActors()
    {
        System.out.println("holaaa");
        return this.repository.findAll();
    }

    @RequestMapping(value = "/actor/{id_actor}/film/{id_film}", method = RequestMethod.POST)
    @ResponseBody
    public void postActorInMovie(@PathVariable Long id_actor, @PathVariable Long id_film) {
        if (this.repository.existsById(id_actor) && this.repository2.existsById(id_film)) {
            Actor actor = repository.findActorByActorId(id_actor);
            Film film = repository2.findFilmByFilmId((id_film));
        }
    }
}
