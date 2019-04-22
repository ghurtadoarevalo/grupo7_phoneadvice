package com.grupo7.tarea1.controller;

import com.grupo7.tarea1.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.grupo7.tarea1.models.Film;

@RestController
@RequestMapping("/films")
public class FilmController
{
    @Autowired
    private FilmService filmService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Film findOne(@PathVariable Integer id) {
        return filmService.getFilm(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Film create(@RequestBody Film film) {
        return filmService.saveFilm(film);
    }


    @RequestMapping(value="/actor/{id_actor}",method = RequestMethod.GET)
    public Iterable<Film> getFilmsByActor(@PathVariable Integer id_actor)
    {
        return filmService.getFilmByActor(id_actor);
    }


}