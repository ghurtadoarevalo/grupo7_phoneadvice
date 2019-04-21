package com.tbd.phoneadvice.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tbd.phoneadvice.mysql.models.Actor;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
    List<Actor> findActorsByFilms(Long id);
    Actor findActorByActorId(Long id);
}

