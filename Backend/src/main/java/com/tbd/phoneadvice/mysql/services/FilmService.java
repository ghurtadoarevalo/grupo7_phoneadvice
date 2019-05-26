/*
package com.tbd.phoneadvice.mysql.services;


import com.tbd.phoneadvice.mysql.repositories.ActorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.tbd.phoneadvice.mysql.repositories.FilmRepository;

import java.util.List;


@RestController
@RequestMapping(value = "/films")
@CrossOrigin(origins = "*")
public class FilmService {

    @Autowired
    private FilmRepository repository;
    @Autowired
    private ActorRepository repository2;

    @RequestMapping(value = "/{id}/actors", method = RequestMethod.GET)
    @ResponseBody
    public List<Actor> getActorsByMovies(@PathVariable Long id)
    {
        return this.repository2.findByFilms_FilmId(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Film> getActors(){
        return this.repository.findAll();
    }

    @RequestMapping(value = "/{id_film}/actor/{id_actor}", method = RequestMethod.GET)
    @ResponseBody
    public void postActorInMovie(@PathVariable Long id_actor, @PathVariable Long id_film) {

        if (this.repository2.existsById(id_actor) && this.repository.existsById(id_film))
        {
            Actor actor = this.repository2.findActorByActorId(id_actor);
            Film film = this.repository.findFilmByFilmId((id_film));
            System.out.println("Existe el actor " + actor.getFirstName() + " " + actor.getLastName());
            System.out.println("Existe la película " + film.getTitle());
            film.getActors().add(actor);
            this.repository.save(film);
        }
    }
}

 */