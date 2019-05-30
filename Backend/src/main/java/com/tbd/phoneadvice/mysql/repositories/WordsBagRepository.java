package com.tbd.phoneadvice.mysql.repositories;

import com.tbd.phoneadvice.mysql.models.WordsBag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordsBagRepository extends JpaRepository<WordsBag, Long> {
}
