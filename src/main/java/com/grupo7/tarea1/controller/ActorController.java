package com.grupo7.tarea1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.grupo7.tarea1.models.Actor;
import com.grupo7.tarea1.services.ActorService;

import java.util.ArrayList;

@RestController
@RequestMapping("/actors")
public class ActorController
{
    //Para marcar inyeccion de dependencia.

    @Autowired
    private ActorService actorService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Actor> getAllUsers() {
        return actorService.getAllActors();
    }

    //Se realiza el metodo GET si no se especifica method
    // == @RequestMapping(/{id});
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Actor findOne(@PathVariable Integer id) {
        return actorService.getActor(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Actor saveActor(@RequestBody Actor actor) {
        return actorService.saveActor(actor);
    }


    @RequestMapping(value="/film/{film_id}", method = RequestMethod.GET)
    public Iterable<Actor> getActorByFilm(@PathVariable Integer film_id)
    {
        return actorService.getActorByFilm(film_id);
    }


    @RequestMapping(value="/filmA/{film_id}", method = RequestMethod.GET)
    public ArrayList<Actor> getActorByFilmA(@PathVariable Integer film_id)
    {
        return actorService.getActorByFilmA(film_id);
    }


}
