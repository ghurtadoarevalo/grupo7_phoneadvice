package com.tbd.phoneadvice.mysql.repositories;

import com.tbd.phoneadvice.mysql.models.Gamma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GammaRepository extends JpaRepository<Gamma, Long> {
    Gamma findByGammaId(Long gammaId);
    Gamma findByName(String name);
}
