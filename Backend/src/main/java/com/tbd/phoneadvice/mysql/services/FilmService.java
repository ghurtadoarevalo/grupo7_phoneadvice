package com.tbd.phoneadvice.mysql.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.tbd.phoneadvice.mysql.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import com.tbd.phoneadvice.mysql.repositories.FilmRepository;

import java.util.List;


@RestController
@RequestMapping(value = "/film")
public class FilmService {

    @Autowired
    private FilmRepository repository;

    @RequestMapping(value = "/{id}/actor", method = RequestMethod.GET)
    @ResponseBody
    public List<Film> getFilmsByActor(@PathVariable Long id)
    {
        return this.repository.findFilmsByActors(id);
    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    @ResponseBody
    public List<Film> getActors(){
        return this.repository.findAll();
    }
}
