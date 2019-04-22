package com.grupo7.tarea1.services;

import com.grupo7.tarea1.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.grupo7.tarea1.models.Film;
import org.springframework.stereotype.Service;


@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public Iterable<Film> getAllFilms()
    {
        return filmRepository.findAll();
    }

    public Film saveFilm(Film f)
    {
        return filmRepository.save(f);
    }

    public Film getFilm(Integer id)
    {
        return filmRepository.findFilmByFilmId(id);
    }


    public Iterable<Film> getFilmByActor(Integer actor_id)
    {
        return filmRepository.findFilmByFilmActorIdActorId(actor_id);
    }


}
