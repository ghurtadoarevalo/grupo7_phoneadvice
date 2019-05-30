package com.tbd.phoneadvice.mysql.repositories;

import com.tbd.phoneadvice.mysql.models.Phone;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {
    //Phone findByPhone_id(int id);

    @Query("SELECT '*' FROM PhoneSpecification ps WHERE ps.phone_specification_id.specification_id = ?1")
    List<Phone> findBySpecifications_Specification_id(Long specification_id);
}

