package com.tbd.phoneadvice.mysql.repositories;

import com.tbd.phoneadvice.mysql.models.Brand;
import com.tbd.phoneadvice.mysql.models.Gamma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findAllByOrderByAssessmentDesc();
    Brand findBrandByBrandId(Long id);
    Brand findByName(String name);
}
