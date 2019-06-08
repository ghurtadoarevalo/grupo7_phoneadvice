package com.tbd.phoneadvice.mysql.repositories;

import com.tbd.phoneadvice.mysql.models.WordSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Word_specificationRepository extends JpaRepository<WordSpecification, Long> {
    List<WordSpecification> findBySpecification_SpecificationId(Long specificationId);
}
