package com.tbd.phoneadvice.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tbd.phoneadvice.mysql.models.Film;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
    List<Film> findFilmsByActors(Long id);
    Film findFilmByFilmId(Long id);

}

