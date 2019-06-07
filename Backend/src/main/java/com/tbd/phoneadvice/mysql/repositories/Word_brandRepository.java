package com.tbd.phoneadvice.mysql.repositories;

import com.tbd.phoneadvice.mysql.models.WordBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Word_brandRepository extends JpaRepository<WordBrand, Long> {
    List<WordBrand> findByBrand_BrandId(Long brandId);

}
