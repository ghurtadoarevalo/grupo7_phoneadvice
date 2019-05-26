/*package com.tbd.phoneadvice.mysql.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.tbd.phoneadvice.mysql.repositories.ActorRepository;
import com.tbd.phoneadvice.mysql.repositories.FilmRepository;

import java.sql.Timestamp;
import java.util.*;


@RestController
@RequestMapping(value = "/actors")
@CrossOrigin(origins = "*")
public class ActorService {

    @Autowired
    private ActorRepository repository;
    @Autowired
    private FilmRepository repository2;

    @RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
    @ResponseBody
    public List<Film> getFilmsByActor(@PathVariable Long id)
    {
        return this.repository2.findByActors_ActorId(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Actor getActorById(@PathVariable Long id)
    {
        return this.repository.findActorByActorId(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Actor> getActors()
    {

        List<Actor> actors = this.repository.findAll();
        System.out.println(actors);
        return actors;
    }

    @RequestMapping(value = "/{id_actor}/film/{id_film}", method = RequestMethod.GET)
    @ResponseBody
    public void postActorInMovie(@PathVariable Long id_actor, @PathVariable Long id_film) {

        if (this.repository.existsById(id_actor) && this.repository2.existsById(id_film))
        {
            Actor actor = this.repository.findActorByActorId(id_actor);
            Film film = this.repository2.findFilmByFilmId((id_film));
            System.out.println("Existe el actor " + actor.getFirstName() + " " + actor.getLastName());
            System.out.println("Existe la película " + film.getTitle());
            film.getActors().add(actor);
            this.repository2.save(film);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Actor addActor(@RequestBody Actor newActor)
    {
        System.out.println(newActor.getFirstName());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        newActor.setLastUpdate(timestamp);
        return repository.save(newActor);

    }
}
*/