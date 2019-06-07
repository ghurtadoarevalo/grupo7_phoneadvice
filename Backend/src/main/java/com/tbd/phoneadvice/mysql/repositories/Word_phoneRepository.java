package com.tbd.phoneadvice.mysql.repositories;

import com.tbd.phoneadvice.mysql.models.WordPhone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Word_phoneRepository extends JpaRepository<WordPhone, Long> {
    List<WordPhone> findByPhone_phoneId(Long phoneId);
}
