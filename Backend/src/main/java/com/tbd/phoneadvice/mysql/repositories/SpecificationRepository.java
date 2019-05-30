package com.tbd.phoneadvice.mysql.repositories;

import com.tbd.phoneadvice.mysql.models.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationRepository extends JpaRepository<Specification, Long> {
}
